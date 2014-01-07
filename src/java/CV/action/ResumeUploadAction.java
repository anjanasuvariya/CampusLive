/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CV.action;

import CV.form.ResumeUploadActionForm;
import CV.model.Uploads;
import assignment.form.CreateAssgForm;
import common.model.CmnUserMst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author SACHIN PATEL
 */
@MultipartConfig
public class ResumeUploadAction extends DispatchAction {

    int BUFFER_LENGTH = 4096;
    private String fileURL;

    public ActionForward uploadResumePage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Added by Jyot for Getting user ID to use in Upload Path
        ResumeUploadActionForm resumeUploadActionForm = (ResumeUploadActionForm) form;
        HttpSession session = request.getSession();
        CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");


        File folder = new File(MessageFormat.format(resourceBundle.getString("UPLOADPATH.RESUME"), System.getenv(resourceBundle.getString("UPLOADPATH.BASE")), lObjCmnUserMst.getUserId()));
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                resumeUploadActionForm.setResume(file);

            }
        }
        return mapping.findForward("success");
    }

    public void downloadResume(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Added by Jyot for Getting user ID to use in Upload Path
        ResumeUploadActionForm resumeUploadActionForm = (ResumeUploadActionForm) form;
        HttpSession session = request.getSession();
        CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");


        File folder = new File(MessageFormat.format(resourceBundle.getString("UPLOADPATH.RESUME"), System.getenv(resourceBundle.getString("UPLOADPATH.BASE")), lObjCmnUserMst.getUserId()));
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                        
//        
        String fileName = file.getName(); 
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        try {
            //Get it from file system
            FileInputStream in = new FileInputStream(file);

            //Get it from web path
            //jndi:/localhost/StrutsExample/upload/superfish.zip
            //URL url = getServlet().getServletContext()
            //               .getResource("upload/superfish.zip");
            //InputStream in = url.openStream();

            //Get it from bytes array
            //byte[] bytes = new byte[4096];
            //InputStream in = new ByteArrayInputStream(bytes);

            ServletOutputStream out = response.getOutputStream();

            byte[] outputByte = new byte[4096];
            //copy binary content to output stream
            while (in.read(outputByte, 0, 4096) != -1) {
                out.write(outputByte, 0, 4096);
            }
            in.close();
            out.flush();
            out.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        
            }
        }




    }

    /* forward name="success" path="" */
    public ActionForward uploadResume(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("INSIDE UPLOAD RESUME METHOD...");

        try {
            System.out.println("INSIDE TRY");
            PrintWriter out = response.getWriter();

            ResumeUploadActionForm resumeUploadActionForm = (ResumeUploadActionForm) form;
            FormFile file = resumeUploadActionForm.getFile();
            HttpSession session = request.getSession();
            ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            String UploadPath = MessageFormat.format(resourceBundle.getString("UPLOADPATH.RESUME"), System.getenv(resourceBundle.getString("UPLOADPATH.BASE")), lObjCmnUserMst.getUserId());

            if (file != null) {
                fileURL = uploadFile(request, file, UploadPath);
            }

            return mapping.findForward("success");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mapping.findForward("success");
    }

    private String uploadFile(HttpServletRequest request, FormFile file, String filePath) throws FileNotFoundException, IOException {

        try {



            File folder = new File(filePath);

            FileUtils.cleanDirectory(folder);

            if (!folder.exists()) {
                System.out.println("Creating:" + filePath);
                folder.mkdirs();
                //folder.mkdir();
            }
            String fileName = file.getFileName();
            if (!("").equals(fileName)) {

                System.out.println("Server path:" + filePath);
                File newFile = new File(filePath, fileName);

                if (!newFile.exists()) {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    System.out.println("Now writing");
                    fos.write(file.getFileData());
                    fos.flush();
                    fos.close();
                    return newFile.getAbsolutePath();
                }
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return "";
    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
