/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import user.dao.UserContactDtlDAO;
import user.dao.UserContactDtlDAOImpl;
import user.dao.UserPersonalDtlDAO;
import user.dao.UserPersonalDtlDAOImpl;
import user.model.UserContactDtls;
import user.model.UserPersonalDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserPersonalDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewUserPersonalDtlForm.class);

    /**
     *
     */
    public ViewUserPersonalDtlForm() {
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
        UserPersonalDtlDAO lObjUserPersonalDtlDAO = new UserPersonalDtlDAOImpl();
        UserPersonalDtls lObjUserPersonalDtl = null;
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            lObjUserPersonalDtl = lObjUserPersonalDtlDAO.getUserPersonalDtl(lObjCmnUserMst.getUserId());

            request.setAttribute("userPersonalDtl", lObjUserPersonalDtl);
        } catch (Exception e) {
            logger.error("Error in view user personal detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
