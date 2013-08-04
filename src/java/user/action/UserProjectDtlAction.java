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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.UserOrganizationDtlDAO;
import user.dao.UserOrganizationDtlDAOImpl;
import user.dao.UserProjectDtlDAO;
import user.dao.UserProjectDtlDAOImpl;
import user.form.UserOrganizationDtlForm;
import user.form.UserProjectDtlForm;
import user.model.UserOrganizationDtls;
import user.model.UserProjectDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserProjectDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        UserProjectDtlDAO lObjUserProjectDtlDAO = new UserProjectDtlDAOImpl();
        List<UserProjectDtls> lLstUserProjectDtls = new ArrayList<UserProjectDtls>();
        try
        {
              HttpSession session = request.getSession();
              CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
              
              //delete existing project detail
              lLstUserProjectDtls = lObjUserProjectDtlDAO.getUserProjectDtls(lObjCmnUserMst.getUserId());
              if(lLstUserProjectDtls != null && !lLstUserProjectDtls.isEmpty())
              {
                  lObjUserProjectDtlDAO.deleteUserProjectDtls(lLstUserProjectDtls);
              }
               //insert project detail
              UserProjectDtlForm userProjectDtlForm = (UserProjectDtlForm) form;
              lLstUserProjectDtls = userProjectDtlForm.getUserProjectDtlList();
              for(int lIntCnt=0;lIntCnt<lLstUserProjectDtls.size();lIntCnt++)
              {
                  UserProjectDtls lObjUserProjectDtl = lLstUserProjectDtls.get(lIntCnt);
                  lObjUserProjectDtl.setCreatedDate(cal.getTime());
                  lObjUserProjectDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                  lObjUserProjectDtlDAO.saveUserProjectDtls(lObjUserProjectDtl);
              }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
        
    }
}
