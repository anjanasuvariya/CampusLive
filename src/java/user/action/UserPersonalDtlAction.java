/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.action;

import com.google.common.io.Files;
import common.dao.UserDAO;
import common.dao.UserDAOImpl;
import common.model.CmnUserMst;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import user.dao.UserPersonalDtlDAO;
import user.dao.UserPersonalDtlDAOImpl;
import user.form.UserPersonalDtlForm;
import user.model.UserPersonalDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserPersonalDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(UserPersonalDtlAction.class);

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UserDAO lObjUserDAO = new UserDAOImpl();
        UserPersonalDtlDAO lObjUserPersonalDtlDAO = new UserPersonalDtlDAOImpl();
        UserPersonalDtls lObjUserPersonalDtl = new UserPersonalDtls();
        CmnUserMst lObjCmnUserMst = new CmnUserMst();
        SimpleDateFormat simpleDateFmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat smpleDateFmt = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();
        UserPersonalDtlForm userPersonalDtlForm = (UserPersonalDtlForm) form;
        try {
            HttpSession session = request.getSession();
            File file = userPersonalDtlForm.getFile();
            //Get the servers upload directory real path name
            /*
             String filePath =
             getServlet().getServletContext().getRealPath("/") + "upload";

             //create the upload folder if not exists
             File folder = new File(filePath);
             if (!folder.exists()) {
             folder.mkdir();
             }
             String fileName = file.getName();
 
             if(!("").equals(fileName)){  
 
             System.out.println("Server path:" +filePath);
             File newFile = new File(filePath, fileName);
 
             if(!newFile.exists()){
             FileOutputStream fos = new FileOutputStream(newFile);
             //fos.write(file.getFileData());
             fos.flush();
             fos.close();
             }  
             lObjUserPersonalDtl.setPersonPhoto(filePath + userPersonalDtlForm.getFile());
             }
             */
//            ServletContext context = session.getServletContext();
//            System.out.println("context path..........." + context.getContextPath());
//            String filePath = context.getRealPath("/");
//            if (userPersonalDtlForm.getFile() != null) {
//                File fileToCreate = new File(filePath, userPersonalDtlForm.getFile().getFileName());
//                System.out.println("userPersonalDtlForm.getUserPhoto().geturi..." + userPersonalDtlForm.getFile().getFileName());
//
//                FileUtils.copyFile((File) userPersonalDtlForm.getFile(), fileToCreate);
//                lObjUserPersonalDtl.setPersonPhoto(filePath + userPersonalDtlForm.getFile());
//            }
            lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            if (!"".equals(userPersonalDtlForm.getUserFirstName())) {
                lObjCmnUserMst.setUserFirstName(userPersonalDtlForm.getUserFirstName());
            }
            if (!"".equals(userPersonalDtlForm.getUserMiddleName())) {
                lObjCmnUserMst.setUserMiddleName(userPersonalDtlForm.getUserMiddleName());
            }
            if (!"".equals(userPersonalDtlForm.getUserFirstName())) {
                lObjCmnUserMst.setUserLastName(userPersonalDtlForm.getUserLastName());
            }
            if (!"".equals(userPersonalDtlForm.getDateOfBirth())) {
                lObjUserPersonalDtl.setDateOfBirth(simpleDateFmt.parse(userPersonalDtlForm.getDateOfBirth()));
            }
            if (!"".equals(userPersonalDtlForm.getGender())) {
                lObjUserPersonalDtl.setGender(userPersonalDtlForm.getGender());
            }
            if (!"".equals(userPersonalDtlForm.getPrimaryLangauge())) {
                lObjUserPersonalDtl.setPrimaryLangauge(userPersonalDtlForm.getPrimaryLangauge());
            }
            if (!"".equals(userPersonalDtlForm.getSecondaryLanguage())) {
                lObjUserPersonalDtl.setSecondaryLanguage(userPersonalDtlForm.getSecondaryLanguage());
            }
            if (!"".equals(userPersonalDtlForm.getInterests())) {
                lObjUserPersonalDtl.setInterests(userPersonalDtlForm.getInterests());
            }
            if (!"".equals(userPersonalDtlForm.getCurrentCity())) {
                lObjUserPersonalDtl.setCurrentCity(userPersonalDtlForm.getCurrentCity());
            }
            if (!"".equals(userPersonalDtlForm.getFacebookLink())) {
                lObjUserPersonalDtl.setFacebookLink(userPersonalDtlForm.getFacebookLink());
            }
            if (!"".equals(userPersonalDtlForm.getTwitterLink())) {
                lObjUserPersonalDtl.setTwitterLink(userPersonalDtlForm.getTwitterLink());
            }
            if (!"".equals(userPersonalDtlForm.getLinkedInLink())) {
                lObjUserPersonalDtl.setLinkedInLink(userPersonalDtlForm.getLinkedInLink());
            }
            if (userPersonalDtlForm.getPersonalDtlId() != null && userPersonalDtlForm.getPersonalDtlId() != 0) {
                lObjUserPersonalDtl.setPersonalDtlId(userPersonalDtlForm.getPersonalDtlId());
                lObjUserPersonalDtl.setUniversityId(userPersonalDtlForm.getUniversityId());
                lObjUserPersonalDtl.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjUserPersonalDtl.setUpdatedDate(cal.getTime());
                lObjUserPersonalDtl.setCreatedUserId(userPersonalDtlForm.getCreatedUserId());
                lObjUserPersonalDtl.setCreatedDate(simpleDateFmt.parse(userPersonalDtlForm.getCreatedDate()));
                lObjCmnUserMst.setUpdatedDate(cal.getTime());
            } else {
                lObjUserPersonalDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjUserPersonalDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjUserPersonalDtl.setCreatedDate(cal.getTime());
            }

            lObjUserPersonalDtlDAO.saveUserPersonalDtls(lObjUserPersonalDtl);
            lObjUserDAO.saveUser(lObjCmnUserMst);
            StringBuilder lStrUserFullName = new StringBuilder();
            lStrUserFullName.append(lObjCmnUserMst.getUserFirstName() != null ? lObjCmnUserMst.getUserFirstName() + " " : "");
            lStrUserFullName.append(lObjCmnUserMst.getUserMiddleName() != null ? lObjCmnUserMst.getUserMiddleName() + " " : "");
            lStrUserFullName.append(lObjCmnUserMst.getUserLastName() != null ? lObjCmnUserMst.getUserLastName() : "");

            session.setAttribute("userName", lStrUserFullName.toString());
            session.setAttribute("cmnUserMst", lObjCmnUserMst);
        } catch (Exception e) {
            logger.error("Error inserting user personal detail : " + e, e);
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
