/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.action;

import common.dao.LoginDAO;
import common.dao.LoginDAOImpl;
import common.form.LoginForm;
import common.model.CmnUserMst;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author SACHIN PATEL
 */
public class LoginAction extends Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    LoginDAO lObjLoginDAO = new LoginDAOImpl();

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
         
          LoginForm loginForm = (LoginForm)form;
          List<CmnUserMst> lLstCmnUserMst = loginForm.getCmnUserMstList();
          CmnUserMst lObjCmnUserMst = new CmnUserMst();
            if(lLstCmnUserMst !=null && !lLstCmnUserMst.isEmpty())
            {
                lObjCmnUserMst = lLstCmnUserMst.get(0);
                HttpSession session = request.getSession();
                session.setAttribute("userName", lObjCmnUserMst.getUserName());
                session.setAttribute("cmnUserMst", lObjCmnUserMst);
                return mapping.findForward("success");
            } else {
              
                return mapping.findForward("fail");
            }
   

    }
}
