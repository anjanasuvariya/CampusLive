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
import user.dao.UserOrganizationDtlDAO;
import user.dao.UserOrganizationDtlDAOImpl;
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserOrganizationDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewUserOrganizationDtlForm.class);
    List<UserOrganizationDtls> userOrganizationDtlList = new ArrayList<UserOrganizationDtls>();

    public List<UserOrganizationDtls> getUserOrganizationDtlList() {
        return userOrganizationDtlList;
    }

    public void setUserOrganizationDtlList(List<UserOrganizationDtls> userOrganizationDtlList) {
        this.userOrganizationDtlList = userOrganizationDtlList;
    }

    /**
     *
     */
    public ViewUserOrganizationDtlForm() {
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
        UserOrganizationDtlDAO lObjUserOrganizationDtlDAO = new UserOrganizationDtlDAOImpl();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            userOrganizationDtlList = lObjUserOrganizationDtlDAO.getUserOrganizationDtls(lObjCmnUserMst.getUserId());
            request.setAttribute("userOrganizationDtlList", userOrganizationDtlList);
        } catch (Exception e) {
            logger.error("Error in view user organization detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
