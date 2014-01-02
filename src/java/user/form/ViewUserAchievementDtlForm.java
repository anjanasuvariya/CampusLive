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
import user.dao.UserAchievementDtlDAO;
import user.dao.UserAchievementDtlDAOImpl;
import user.model.UserAchievementDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserAchievementDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewUserAchievementDtlForm.class);
    List<UserAchievementDtls> userAchievementDtlList = new ArrayList<UserAchievementDtls>();

    public List<UserAchievementDtls> getUserAchievementDtlList() {
        return userAchievementDtlList;
    }

    public void setUserAchievementDtlList(List<UserAchievementDtls> userAchievementDtlList) {
        this.userAchievementDtlList = userAchievementDtlList;
    }

    /**
     *
     */
    public ViewUserAchievementDtlForm() {
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
        UserAchievementDtlDAO lObjUserAchievementDtlDAO = new UserAchievementDtlDAOImpl();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            userAchievementDtlList = lObjUserAchievementDtlDAO.getUserAchievementDtls(lObjCmnUserMst.getUserId());
            request.setAttribute("userAchievementDtlList", userAchievementDtlList);
        } catch (Exception e) {
            logger.error("Error in view user achievement detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
