/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CV.action;

import CV.form.ResumeUploadActionForm;
import CV.model.Uploads;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
      
      HttpSession session = request.getSession(); 
      CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
      
      ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");
   
      System.out.println(MessageFormat.format(resourceBundle.getString("UPLOADPATH.RESUME"),lObjCmnUserMst.getUserId()));
   
      
      
  return mapping.findForward("success");
  }
  
  
    /* forward name="success" path="" */
 public ActionForward uploadResume(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("INSIDE UPLOAD RESUME METHOD...");
        System.out.println(System.getenv("uploadpath"));
    try{
        System.out.println("INSIDE TRY");
        PrintWriter out = response.getWriter();
        
        ResumeUploadActionForm resumeUploadActionForm = (ResumeUploadActionForm) form;
        FormFile file = resumeUploadActionForm.getFile();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");
        
        
        if (file != null) {
                fileURL = uploadFile(request, file);
        }

        return mapping.findForward("success");
    
    }catch(Exception ex){
    ex.printStackTrace();
    }
    
        return mapping.findForward("success");
    }
 
 private String uploadFile(HttpServletRequest request, FormFile file) throws FileNotFoundException, IOException {

        try {
            request.getSession().setAttribute("userId", 1);
            String filePath = System.getenv("uploadpath") +"\\"+ request.getSession().getAttribute("userId") + "\\resume";
            
            File folder = new File(filePath);
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
