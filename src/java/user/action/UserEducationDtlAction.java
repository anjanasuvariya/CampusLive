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
import user.dao.UserEducationDtlDAO;
import user.dao.UserEducationDtlDAOImpl;
import user.form.UserEducationDtlForm;
import user.model.UserEducationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserEducationDtlAction extends org.apache.struts.action.Action {

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
        UserEducationDtlDAO lObjUserEducationDtlDAO = new UserEducationDtlDAOImpl();
        List<UserEducationDtls> lLstUserEducationDtls = new ArrayList<UserEducationDtls>();
        try
        {
              HttpSession session = request.getSession();
              CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
              
              //delete existing education detail
              lLstUserEducationDtls = lObjUserEducationDtlDAO.getUserEducationDtls(lObjCmnUserMst.getUserId());
              if(lLstUserEducationDtls != null && !lLstUserEducationDtls.isEmpty())
              {
                  lObjUserEducationDtlDAO.deleteUserEducationDtls(lLstUserEducationDtls);
              }
               //insert education detail
              UserEducationDtlForm userEducationDtlForm = (UserEducationDtlForm) form;
              lLstUserEducationDtls = userEducationDtlForm.getUserEducationDtlList();
              for(int lIntCnt=0;lIntCnt<lLstUserEducationDtls.size();lIntCnt++)
              {
                  UserEducationDtls lObjUserEducationDtl = lLstUserEducationDtls.get(lIntCnt);
                  lObjUserEducationDtl.setCreatedDate(cal.getTime());
                  lObjUserEducationDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                  lObjUserEducationDtlDAO.saveUserEducationDtls(lObjUserEducationDtl);
              }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
