/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.form;

import common.dao.UserDAO;
import common.dao.UserDAOImpl;
import common.model.CmnRoleActivationMpg;
import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author SACHIN PATEL
 */
public class UserForm extends org.apache.struts.action.ActionForm {
   
     private String userName;
     private String userPassword;
     private String userActivationCode;
     private String signUp;

    public String getSignUp() {
        return signUp;
    }

    public void setSignUp(String signUp) {
        this.signUp = signUp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserActivationCode() {
        return userActivationCode;
    }

    public void setUserActivationCode(String userActivationCode) {
        this.userActivationCode = userActivationCode;
    }
     
     

    /**
     *
     */
    public UserForm() {
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
        ActionErrors actionErrors = new ActionErrors();
     
        UserDAO gObjUserDAO = new UserDAOImpl();
        if (getUserName() == null || getUserName().length() < 1) {
            
            actionErrors.add("userName", new ActionMessage("error.userName"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getUserPassword() == null || getUserPassword().length() < 1) {
            actionErrors.add("userPassword", new ActionMessage("error.userPassword"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getUserActivationCode() == null || getUserActivationCode().length() < 1) {
            actionErrors.add("userActivationCode", new ActionMessage("error.userActivationCode"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getUserName() != null && getUserName().length() > 0) {
            
            try {
                List<CmnUserMst> lLstCmnUserMst = new ArrayList<CmnUserMst>();
                lLstCmnUserMst = gObjUserDAO.validateUserName(getUserName().toUpperCase());
                if(!lLstCmnUserMst.isEmpty()) {
                    actionErrors.add("userName", new ActionMessage("error.duplicateUserName"));
                    
                }
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if (getUserActivationCode() != null && getUserActivationCode().length() > 0) {
            try {
                List<CmnRoleActivationMpg> lLstCmnRoleActivationMpg = new ArrayList<CmnRoleActivationMpg>();
                lLstCmnRoleActivationMpg = gObjUserDAO.validateActivationCode(getUserActivationCode());
                if (lLstCmnRoleActivationMpg.isEmpty()) {
                    actionErrors.add("userActivationCode", new ActionMessage("error.validateUserActivationCode"));
                    
                }
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
         request.setAttribute("fromFlag", "signUp");
        return actionErrors;
    }
}
