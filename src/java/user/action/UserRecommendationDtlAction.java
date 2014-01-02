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
import user.dao.UserRecommendationDtlDAO;
import user.dao.UserRecommendationDtlDAOImpl;
import user.form.UserRecommendationDtlForm;
import user.model.UserRecommendationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserRecommendationDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
private static final Logger logger = Logger.getLogger(UserRecommendationDtlAction.class);
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
        UserRecommendationDtlDAO lObjUserRecommendationDtlDAO = new UserRecommendationDtlDAOImpl();
        List<UserRecommendationDtls> lLstUserRecommendationDtls = new ArrayList<UserRecommendationDtls>();
        try
        {
              HttpSession session = request.getSession();
              CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
              
              //delete existing Recommendation detail
              lLstUserRecommendationDtls = lObjUserRecommendationDtlDAO.getUserRecommendationDtls(lObjCmnUserMst.getUserId());
              if(lLstUserRecommendationDtls != null && !lLstUserRecommendationDtls.isEmpty())
              {
                  lObjUserRecommendationDtlDAO.deleteUserRecommendationDtls(lLstUserRecommendationDtls);
              }
               //insert project detail
              UserRecommendationDtlForm userRecommendationDtlForm = (UserRecommendationDtlForm) form;
              lLstUserRecommendationDtls = userRecommendationDtlForm.getUserRecommendationDtlList();
              for(int lIntCnt=0;lIntCnt<lLstUserRecommendationDtls.size();lIntCnt++)
              {
                  UserRecommendationDtls lObjUserRecommendationDtl = lLstUserRecommendationDtls.get(lIntCnt);
                  lObjUserRecommendationDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                  lObjUserRecommendationDtl.setCreatedDate(cal.getTime());
                  lObjUserRecommendationDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                  lObjUserRecommendationDtlDAO.saveUserRecommendationDtls(lObjUserRecommendationDtl);
              }
        }
        catch(Exception e)
        {
            logger.error("Error inserting user recommendation detail : " + e, e);
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
