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

import user.dao.UserAchievementDtlDAO;
import user.dao.UserAchievementDtlDAOImpl;
import user.form.UserAchievementDtlForm;
import user.model.UserAchievementDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserAchievementDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(UserAchievementDtlAction.class);

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
        UserAchievementDtlDAO lObjUserAchievementDtlDAO = new UserAchievementDtlDAOImpl();
        List<UserAchievementDtls> lLstUserAchievementDtls = new ArrayList<UserAchievementDtls>();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            //Delete existing user achievement details
            lLstUserAchievementDtls = lObjUserAchievementDtlDAO.getUserAchievementDtls(lObjCmnUserMst.getUserId());
            if (lLstUserAchievementDtls != null && !lLstUserAchievementDtls.isEmpty()) {
                lObjUserAchievementDtlDAO.deleteUserAchievementDtls(lLstUserAchievementDtls);
            }
            //insert achievement detail
            UserAchievementDtlForm userAchievementDtlForm = (UserAchievementDtlForm) form;
            lLstUserAchievementDtls = userAchievementDtlForm.getUserAchievementDtlList();
            for (int lIntCnt = 0; lIntCnt < lLstUserAchievementDtls.size(); lIntCnt++) {
                UserAchievementDtls lObjUserAchievementDtl = lLstUserAchievementDtls.get(lIntCnt);
                lObjUserAchievementDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjUserAchievementDtl.setCreatedDate(cal.getTime());
                lObjUserAchievementDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjUserAchievementDtlDAO.saveUserAchievementDtls(lObjUserAchievementDtl);
            }
        } catch (Exception e) {
            logger.error("Error inserting user achievement detail : " + e, e);
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);

    }
}
