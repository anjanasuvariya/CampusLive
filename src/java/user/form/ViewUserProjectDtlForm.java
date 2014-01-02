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
import user.dao.UserProjectDtlDAO;
import user.dao.UserProjectDtlDAOImpl;
import user.model.UserProjectDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserProjectDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewUserProjectDtlForm.class);
    List<UserProjectDtls> userProjectDtlList = new ArrayList<UserProjectDtls>();

    public List<UserProjectDtls> getUserProjectDtlList() {
        return userProjectDtlList;
    }

    public void setUserProjectDtlList(List<UserProjectDtls> userProjectDtlList) {
        this.userProjectDtlList = userProjectDtlList;
    }

    /**
     *
     */
    public ViewUserProjectDtlForm() {
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
        UserProjectDtlDAO lObjUserProjectDtlDAO = new UserProjectDtlDAOImpl();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            userProjectDtlList = lObjUserProjectDtlDAO.getUserProjectDtls(lObjCmnUserMst.getUserId());
            request.setAttribute("userProjectDtlList", userProjectDtlList);
        } catch (Exception e) {
            logger.error("Error in view user project detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
