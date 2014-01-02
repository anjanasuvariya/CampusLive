/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import user.model.UserProjectDtls;
import user.model.UserRecommendationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserRecommendationDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserRecommendationDtlForm.class);
    List<UserRecommendationDtls> userRecommendationDtlList = new ArrayList<UserRecommendationDtls>();

    public List<UserRecommendationDtls> getUserRecommendationDtlList() {
        return userRecommendationDtlList;
    }

    public void setUserRecommendationDtlList(List<UserRecommendationDtls> userRecommendationDtlList) {
        this.userRecommendationDtlList = userRecommendationDtlList;
    }

    /**
     *
     */
    public UserRecommendationDtlForm() {
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
            String[] lStrRecmdTitle = request.getParameterValues("hdnRecmdTitle");
            String[] lStrRecmdBy = request.getParameterValues("hdnRecmdBy");
            String[] lStrRecmdLocation = request.getParameterValues("hdnRecmdLocation");
            String[] lStrRecmdDesc = request.getParameterValues("hdnRecmdDesc");

            UserRecommendationDtls lObjUserRecommendationDtl = null;
            for (int lIntCnt = 0; lIntCnt < lStrRecmdTitle.length; lIntCnt++) {
                lObjUserRecommendationDtl = new UserRecommendationDtls();
                if (lStrRecmdTitle[lIntCnt] != null && !"".equals(lStrRecmdTitle[lIntCnt])) {
                    lObjUserRecommendationDtl.setRecmdTitle(lStrRecmdTitle[lIntCnt]);
                }
                if (lStrRecmdBy[lIntCnt] != null && !"".equals(lStrRecmdBy[lIntCnt])) {
                    lObjUserRecommendationDtl.setRecmdBy(lStrRecmdBy[lIntCnt]);
                }
                if (lStrRecmdLocation[lIntCnt] != null && !"".equals(lStrRecmdLocation[lIntCnt])) {
                    lObjUserRecommendationDtl.setRecmdCompanyLocation(lStrRecmdLocation[lIntCnt]);
                }
                if (lStrRecmdDesc[lIntCnt] != null && !"".equals(lStrRecmdDesc[lIntCnt])) {
                    lObjUserRecommendationDtl.setRecmdDescription(lStrRecmdDesc[lIntCnt]);
                }
                userRecommendationDtlList.add(lObjUserRecommendationDtl);
            }

        } catch (Exception e) {
            logger.error("Error in user recommendation detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
