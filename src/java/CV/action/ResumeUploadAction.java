/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CV.action;

import admin.dao.UserActivationDtlDAO;
import admin.dao.UserActivationDtlDAOImpl;
import admin.model.TmpUserExcelData;
import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;

/**
 *
 * @author SACHIN PATEL
 */
public class ResumeUploadAction extends DispatchAction {

    /* forward name="success" path="" */
 public ActionForward uploadResume(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("INSIDE RESUME METHOD...");
        System.out.println(System.getenv("uploadpath"));
        return mapping.findForward("success");
    }
    
}
