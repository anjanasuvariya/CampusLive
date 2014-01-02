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
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.log4j.Logger;
import placeComm.model.PcHrDtls;
import admin.model.TmpUserExcelData;

/**
 *
 * @author SACHIN PATEL
 */
public class UserForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserForm.class);
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String userName;
    private String userPassword;
    private String userActivationCode;
    private String signUp;
    private String userType;
    private List roleActivationMpgList;
    private Long universityId;

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

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List getRoleActivationMpgList() {
        return roleActivationMpgList;
    }

    public void setRoleActivationMpgList(List roleActivationMpgList) {
        this.roleActivationMpgList = roleActivationMpgList;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
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
        try {
            UserDAO gObjUserDAO = new UserDAOImpl();
            if (userFirstName == null || userFirstName.length() < 1) {

                actionErrors.add("userFirstName", new ActionMessage("error.userFirstName"));
                // TODO: add 'error.name.required' key to your resources
            }
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

                List<CmnUserMst> lLstCmnUserMst = new ArrayList<CmnUserMst>();
                lLstCmnUserMst = gObjUserDAO.validateUserName(getUserName().toUpperCase());
                if (!lLstCmnUserMst.isEmpty()) {
                    actionErrors.add("userName", new ActionMessage("error.duplicateUserName"));

                }

            }
            if (getUserActivationCode() != null && getUserActivationCode().length() > 0) {

                System.out.println("userType....." + userType);
                logger.info("userType......" + userType);
                if (userType != null && !"".equals(userType) && "H".equals(userType)) {
                    roleActivationMpgList = gObjUserDAO.validateActivationCodeForHR(getUserActivationCode());
                    if (roleActivationMpgList != null && !roleActivationMpgList.isEmpty()) {
                        PcHrDtls lObjPcHrDtls = (PcHrDtls) roleActivationMpgList.get(0);
                        universityId = lObjPcHrDtls.getUniversityId();
                    }
                }
                else  if (userType != null && !"".equals(userType) && ("S".equals(userType) || "A".equals(userType)  || "F".equals(userType))) {
                    roleActivationMpgList = gObjUserDAO.validateActnCodeForStudOrAlumniOfFaculty(userType,userActivationCode);
                    if(roleActivationMpgList != null && !roleActivationMpgList.isEmpty())
                    {
                        List lLstResult = gObjUserDAO.validateActivationCodeWithExistingCode(userActivationCode);
                        if(lLstResult != null && !lLstResult.isEmpty())
                        {
                           actionErrors.add("userActivationCode", new ActionMessage("error.validateUserActivationCodeWithExistingCode")); 
                        }
                        else
                        {
                            TmpUserExcelData lObjTmpUserExcelData = (TmpUserExcelData) roleActivationMpgList.get(0);
                            universityId = lObjTmpUserExcelData.getUniversityId();
                        }
                    }
                } 
                else {
                    roleActivationMpgList = gObjUserDAO.validateActivationCode(getUserActivationCode());
                    if (roleActivationMpgList != null && !roleActivationMpgList.isEmpty()) {
                        CmnRoleActivationMpg lObjCmnRoleActivationMpg = (CmnRoleActivationMpg) roleActivationMpgList.get(0);
                        universityId = lObjCmnRoleActivationMpg.getUniversityId();
                    }
                }

                if (roleActivationMpgList == null || roleActivationMpgList.isEmpty()) {
                    actionErrors.add("userActivationCode", new ActionMessage("error.validateUserActivationCode"));

                }
            }
            request.setAttribute("fromFlag", "signUp");
        } catch (Exception ex) {
            logger.error("Error while validating user data : " + ex, ex);
        }
        return actionErrors;
    }
}
