/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.action;

import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.UserOrganizationDtlDAO;
import user.dao.UserOrganizationDtlDAOImpl;
import user.form.UserOrganizationDtlForm;
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserOrganizationDtlAction extends org.apache.struts.action.Action {

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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Calendar cal = Calendar.getInstance();
        UserOrganizationDtlDAO lObjUserOrganizationDtlDAO = new UserOrganizationDtlDAOImpl();
        List<UserOrganizationDtls> lLstUserOrganizationDtls = new ArrayList<UserOrganizationDtls>();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            //delete existing Organization detail
            lLstUserOrganizationDtls = lObjUserOrganizationDtlDAO.getUserOrganizationDtls(lObjCmnUserMst.getUserId());
            if (lLstUserOrganizationDtls != null && !lLstUserOrganizationDtls.isEmpty()) {
                lObjUserOrganizationDtlDAO.deleteUserOrganizationDtls(lLstUserOrganizationDtls);
            }
            //insert Organization detail
            UserOrganizationDtlForm userOrganizationDtlForm = (UserOrganizationDtlForm) form;
            lLstUserOrganizationDtls = userOrganizationDtlForm.getUserOrganizationDtlList();
            for (int lIntCnt = 0; lIntCnt < lLstUserOrganizationDtls.size(); lIntCnt++) {
                UserOrganizationDtls lObjUserOrganizationDtl = lLstUserOrganizationDtls.get(lIntCnt);
                lObjUserOrganizationDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjUserOrganizationDtl.setCreatedDate(cal.getTime());
                lObjUserOrganizationDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjUserOrganizationDtlDAO.saveUserOrganizationDtls(lObjUserOrganizationDtl);
            }
        } catch (Exception e) {
            logger.error("Error inserting user organization detail : " + e, e);
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
