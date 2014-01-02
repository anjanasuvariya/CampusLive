/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.form;

import admin.dao.UserActivationDtlDAO;
import admin.dao.UserActivationDtlDAOImpl;
import common.dao.UserDAO;
import common.dao.UserDAOImpl;
import common.model.CmnUserMst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import placeComm.dao.StudentInterestInviteDAO;
import placeComm.dao.StudentInterestInviteDAOImpl;
import placeComm.model.StudentInterestInviteCustomVO;
import admin.model.TmpUserExcelData;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserActivationDtlForm extends org.apache.struts.action.ActionForm {
    
   private static final Logger logger = Logger.getLogger(ViewUserActivationDtlForm.class);
    /**
     *
     */
    public ViewUserActivationDtlForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        UserActivationDtlDAO lObjUserActivationDtlDAO = new UserActivationDtlDAOImpl();
        List<TmpUserExcelData> lLstTmpUserExcelData = new ArrayList<TmpUserExcelData>();
      
        try {

            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            lLstTmpUserExcelData = lObjUserActivationDtlDAO.getUserActivationDtls(lObjCmnUserMst.getUniversityId());

            request.setAttribute("userActivationList", lLstTmpUserExcelData);

        } catch (Exception e) {
            logger.error("Error in ViewUserActivationDtlForm : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
