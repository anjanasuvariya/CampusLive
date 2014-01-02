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
import user.model.UserAchievementDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserAchievementDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserAchievementDtlForm.class);
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
    public UserAchievementDtlForm() {
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
        try {
            String[] lStrAchievementTitle = request.getParameterValues("hdnAchievementTitle");
            String[] lStrCategory = request.getParameterValues("hdnCategory");
            String[] lStrEventName = request.getParameterValues("hdnEventName");
            String[] lStrOrganizers = request.getParameterValues("hdnOrganizers");
            String[] lStrDescription = request.getParameterValues("hdnDescription");

            UserAchievementDtls lObjUserAchievementDtl = null;
            if (lStrAchievementTitle != null && lStrAchievementTitle.length > 0) {
                for (int lIntCnt = 0; lIntCnt < lStrAchievementTitle.length; lIntCnt++) {
                    lObjUserAchievementDtl = new UserAchievementDtls();
                    if (!"".equals(lStrAchievementTitle[lIntCnt])) {
                        lObjUserAchievementDtl.setAchievementTitle(lStrAchievementTitle[lIntCnt]);
                    }
                    if (!"".equals(lStrCategory[lIntCnt])) {
                        lObjUserAchievementDtl.setAchievementCategory(lStrCategory[lIntCnt]);
                    }
                    if (!"".equals(lStrEventName[lIntCnt])) {
                        lObjUserAchievementDtl.setEventName(lStrEventName[lIntCnt]);
                    }
                    if (!"".equals(lStrDescription[lIntCnt])) {
                        lObjUserAchievementDtl.setEventDescription(lStrDescription[lIntCnt]);
                    }
                    if (!"".equals(lStrOrganizers[lIntCnt])) {
                        lObjUserAchievementDtl.setEventOrganizers(lStrOrganizers[lIntCnt]);
                    }

                    userAchievementDtlList.add(lObjUserAchievementDtl);
                }
            } else {
                errors.add("achievementTitle", new ActionMessage("error.achievement.required"));
            }

        } catch (Exception e) {
            logger.error("Error in user achievement detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
