/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.action;

import admin.dao.UserActivationDtlDAO;
import admin.dao.UserActivationDtlDAOImpl;
import admin.model.TmpUserExcelData;
import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;
import user.action.UserOrganizationDtlAction;

/**
 *
 * @author SACHIN PATEL
 */
public class UserActivationDtlAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(UserOrganizationDtlAction.class);

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
    public ActionForward sendUserActivationDtlByMail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            UserActivationDtlDAO lObjUserActivationDtlDAO = new UserActivationDtlDAOImpl();
            String lStrUserActIds = request.getParameter("userActIds");
            List<Long> lLstActId = new ArrayList<Long>();
            List<TmpUserExcelData> lLstUserData = new ArrayList<TmpUserExcelData>();
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            if (lStrUserActIds != null && !"".equals(lStrUserActIds)) {

                String[] lArrStrActIds = lStrUserActIds.split("~");
                for (int lIntCnt = 0; lIntCnt < lArrStrActIds.length; lIntCnt++) {
                    lLstActId.add(Long.parseLong(lArrStrActIds[lIntCnt]));
                }
                lLstUserData = lObjUserActivationDtlDAO.getUserActivationDtlsByIds(lObjCmnUserMst.getUniversityId(), lLstActId);

                System.out.println("Starting to send...");
                String host = "smtp.gmail.com";
                String from = "anjanasuvariya@gmail.com";
                String pass = "";
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true"); // added this line
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.user", from);
                props.put("mail.smtp.password", pass);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");


                Session lObjSession = Session.getDefaultInstance(props, null);
                MimeMessage message = new MimeMessage(lObjSession);
                message.setFrom(new InternetAddress(from));


                StringBuffer lStrMessage = null;
                for (int lIntCnt = 0; lIntCnt < lLstUserData.size(); lIntCnt++) {
                    TmpUserExcelData lObjTmpUserExcelData = lLstUserData.get(lIntCnt);

                    InternetAddress lObjToAddress = new InternetAddress(lObjTmpUserExcelData.getEmailId());

                    message.addRecipient(Message.RecipientType.TO, lObjToAddress);
                    lStrMessage = new StringBuffer();
                    lStrMessage.append("Hi " + lObjTmpUserExcelData.getUserFullName() + ",");
                    lStrMessage.append("\n\n\nPlease register on campusLive site through " + lObjTmpUserExcelData.getActivationCode() + " activation code");
                    lStrMessage.append("\n\nPlease don't share this code.");
                    lStrMessage.append("\n\n*This code is one time use only.");
                    lStrMessage.append("\n\n*This is a system generated mail, no need to reply.");
                    System.out.println("Hey");
                    message.setSubject("Your Activation code");
                    message.setText(lStrMessage.toString());
                    Transport transport = lObjSession.getTransport("smtp");
                    System.out.println("Now Connecting");
                    transport.connect(host, from, pass);
                    System.out.println("Connected");
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                }


                System.out.println("end");

            }
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("success", "success");
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info(jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            logger.error("Error in sendUserActivationDtlByMail method of UserActivationDtlAction : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
