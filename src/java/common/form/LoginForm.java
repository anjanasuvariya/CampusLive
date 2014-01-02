/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.form;


import common.dao.LoginDAO;
import common.dao.LoginDAOImpl;
import common.model.CmnUserMst;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author SACHIN PATEL
 */
public class LoginForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(LoginForm.class);
    private String userName;
    private String userPassword;
    List<CmnUserMst> cmnUserMstList;

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

    public List<CmnUserMst> getCmnUserMstList() {
        return cmnUserMstList;
    }

    public void setCmnUserMstList(List<CmnUserMst> cmnUserMstList) {
        this.cmnUserMstList = cmnUserMstList;
    }

    /**
     *
     */
    public LoginForm() {
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
        try {
            LoginDAO lObjLoginDAO = new LoginDAOImpl();
            if (getUserName() == null || getUserName().length() < 1) {

                actionErrors.add("userName", new ActionMessage("error.userName"));
                // TODO: add 'error.name.required' key to your resources
            }
            if (getUserPassword() == null || getUserPassword().length() < 1) {
                actionErrors.add("userPassword", new ActionMessage("error.userPassword"));
                // TODO: add 'error.name.required' key to your resources
            }
            if (getUserName() != null && getUserName().length() >= 1 && getUserPassword() != null && getUserPassword().length() >= 1) {

                cmnUserMstList = lObjLoginDAO.getUserDtlFromUserNameAndPassword(getUserName().toUpperCase(), getUserPassword());
                if (cmnUserMstList.isEmpty()) {
                    actionErrors.add("userPassword", new ActionMessage("error.loginFail"));
                }

            }
            request.setAttribute("fromFlag", "signIn");
        } catch (Exception ex) {
            logger.error("Error while validating login data : " + ex, ex);
            ex.printStackTrace();
        }
        return actionErrors;
    }
}
