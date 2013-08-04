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

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import user.dao.UserProjectDtlDAO;
import user.dao.UserProjectDtlDAOImpl;
import user.dao.UserRecommendationDtlDAO;
import user.dao.UserRecommendationDtlDAOImpl;
import user.model.UserProjectDtls;
import user.model.UserRecommendationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserRecommendationDtlForm extends org.apache.struts.action.ActionForm {
    
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
    public ViewUserRecommendationDtlForm() {
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
       UserRecommendationDtlDAO lObjUserRecommendationDtlDAO = new UserRecommendationDtlDAOImpl();
        try
        {
              HttpSession session = request.getSession();
              CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
              userRecommendationDtlList = lObjUserRecommendationDtlDAO.getUserRecommendationDtls(lObjCmnUserMst.getUserId());
              request.setAttribute("userRecommendationDtlList", userRecommendationDtlList);
        }     
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return errors;
    }
}
