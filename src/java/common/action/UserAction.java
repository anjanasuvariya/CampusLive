/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.action;

import common.dao.UserDAO;
import common.dao.UserDAOImpl;
import common.form.UserForm;
import common.model.CmnRoleActivationMpg;
import common.model.CmnUserMst;
import common.model.CmnUserRoleRlt;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author SACHIN PATEL
 */
public class UserAction extends org.apache.struts.action.Action {

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
            CmnUserRoleRlt cmnUserRoleRlt = new CmnUserRoleRlt();
            UserDAO lObjUserDAO = new UserDAOImpl();
            CmnUserMst cmnUserMst =new CmnUserMst();
            UserForm userForm = (UserForm)form;
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            
            List<CmnRoleActivationMpg> lLstCmnRoleActivationMpg = lObjUserDAO.validateActivationCode(userForm.getUserActivationCode());

            if (lLstCmnRoleActivationMpg != null && !lLstCmnRoleActivationMpg.isEmpty()) {
                
                CmnRoleActivationMpg lObjCmnRoleActivationMpg = lLstCmnRoleActivationMpg.get(0);
                
                cmnUserMst.setUserName(userForm.getUserName().toUpperCase());
                cmnUserMst.setUserPassword(userForm.getUserPassword());
                cmnUserMst.setActivateFlag("Y");
                cmnUserMst.setIsLocked("N");
                cmnUserMst.setUniversityId(lObjCmnRoleActivationMpg.getUniversityId());
                cmnUserMst.setUserActivationCode(lObjCmnRoleActivationMpg.getActivationCode());
                cmnUserMst.setCreatedUserId(cmnUserMst.getUserId());
                cmnUserMst.setCreatedDate(cal.getTime());
                lObjUserDAO.createUser(cmnUserMst);

                
                cmnUserRoleRlt.setRoleId(lObjCmnRoleActivationMpg.getRoleId());
                cmnUserRoleRlt.setUniversityId(lObjCmnRoleActivationMpg.getUniversityId());
                cmnUserRoleRlt.setUserId(cmnUserMst.getUserId());
                cmnUserRoleRlt.setActivateFlag("Y");
                cmnUserRoleRlt.setCreatedUserId(cmnUserMst.getUserId());
                cmnUserRoleRlt.setCreatedDate(cal.getTime());
                lObjUserDAO.insertUserRoleMpgDtl(cmnUserRoleRlt);
                
                
                HttpSession session = request.getSession();
                session.setAttribute("userName", cmnUserMst.getUserName());
                session.setAttribute("cmnUserMst", cmnUserMst);
                
                return mapping.findForward("success");
            }
            else
            {
                return mapping.findForward("fail");
            }
    }
}
