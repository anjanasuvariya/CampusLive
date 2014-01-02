/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.action;

import admin.dao.UserActivationDtlDAO;
import admin.dao.UserActivationDtlDAOImpl;
import admin.model.TmpUserExcelData;
import common.dao.UserDAO;
import common.dao.UserDAOImpl;
import common.form.UserForm;
import common.model.CmnRoleActivationMpg;
import common.model.CmnUserMst;
import common.model.CmnUserRoleRlt;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import placeComm.dao.HrDtlDAO;
import placeComm.dao.HrDtlDAOImpl;
import placeComm.model.PcHrDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(UserAction.class);

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
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("common/resources/Constants");

            CmnUserRoleRlt cmnUserRoleRlt = new CmnUserRoleRlt();
            UserDAO lObjUserDAO = new UserDAOImpl();
            CmnUserMst cmnUserMst = new CmnUserMst();
            UserForm userForm = (UserForm) form;
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
//          CmnRoleActivationMpg lObjCmnRoleActivationMpg = null;

            List lLstRoleActivationMpg = userForm.getRoleActivationMpgList();

            if (lLstRoleActivationMpg != null && !lLstRoleActivationMpg.isEmpty()) {

//                Object obj = lLstRoleActivationMpg.get(0);
//                if (obj instanceof CmnRoleActivationMpg) {
//                    lObjCmnRoleActivationMpg = (CmnRoleActivationMpg) obj;
//                }
                if (userForm.getUserFirstName() != null && !"".equals(userForm.getUserFirstName())) {
                    cmnUserMst.setUserFirstName(userForm.getUserFirstName());
                }
                if (userForm.getUserMiddleName() != null && !"".equals(userForm.getUserMiddleName())) {
                    cmnUserMst.setUserMiddleName(userForm.getUserMiddleName());
                }
                if (userForm.getUserLastName() != null && !"".equals(userForm.getUserLastName())) {
                    cmnUserMst.setUserLastName(userForm.getUserLastName());
                }

                cmnUserMst.setUserName(userForm.getUserName().toUpperCase());
                cmnUserMst.setUserPassword(userForm.getUserPassword());
                cmnUserMst.setActivateFlag("Y");
                cmnUserMst.setIsLocked("N");
                cmnUserMst.setUniversityId(userForm.getUniversityId());
                cmnUserMst.setUserActivationCode(userForm.getUserActivationCode());
                cmnUserMst.setCreatedUserId(cmnUserMst.getUserId());
                cmnUserMst.setCreatedDate(cal.getTime());
                lObjUserDAO.saveUser(cmnUserMst);

                if (!"".equals(userForm.getUserType())) {
                    if ("H".equals(userForm.getUserType())) {
                        cmnUserRoleRlt.setRoleId(Long.parseLong(resourceBundle.getString("ROLE.HR")));
                        PcHrDtls lObjPcHrDtls = (PcHrDtls) lLstRoleActivationMpg.get(0);
                        HrDtlDAO lObjHrDtlDAO =  new HrDtlDAOImpl();
                        logger.info("user id...."+cmnUserMst.getUserId());
                        lObjPcHrDtls.setHrUserId(cmnUserMst.getUserId());
                        lObjHrDtlDAO.saveHrDtls(lObjPcHrDtls);
                    } else if ("S".equals(userForm.getUserType())) {
                        cmnUserRoleRlt.setRoleId(Long.parseLong(resourceBundle.getString("ROLE.STUDENT")));
                    } else if ("A".equals(userForm.getUserType())) {
                        cmnUserRoleRlt.setRoleId(Long.parseLong(resourceBundle.getString("ROLE.ALUMNI")));
                    } else if ("F".equals(userForm.getUserType())) {
                        cmnUserRoleRlt.setRoleId(Long.parseLong(resourceBundle.getString("ROLE.FACULTY")));
                    }
                    
                    if("S".equals(userForm.getUserType()) || "A".equals(userForm.getUserType()) || "F".equals(userForm.getUserType()))
                    {
                        //save TmpUserExcelData user id
                        UserActivationDtlDAO lObjUserActivationDtlDAO = new UserActivationDtlDAOImpl();
                        TmpUserExcelData lObjTmpUserExcelData = (TmpUserExcelData) lLstRoleActivationMpg.get(0);
                        logger.info("user id...."+cmnUserMst.getUserId());
                        lObjTmpUserExcelData.setUserId(cmnUserMst.getUserId());
                        lObjUserActivationDtlDAO.updateUserIdInUserExcelData(lObjTmpUserExcelData);
                    }
                }

                cmnUserRoleRlt.setUniversityId(userForm.getUniversityId());
                cmnUserRoleRlt.setUserId(cmnUserMst.getUserId());
                cmnUserRoleRlt.setActivateFlag("Y");
                cmnUserRoleRlt.setCreatedUserId(cmnUserMst.getUserId());
                cmnUserRoleRlt.setCreatedDate(cal.getTime());
                lObjUserDAO.insertUserRoleMpgDtl(cmnUserRoleRlt);

                StringBuilder lStrUserFullName = new StringBuilder();
                lStrUserFullName.append(cmnUserMst.getUserFirstName() != null ? cmnUserMst.getUserFirstName() + " " : "");
                lStrUserFullName.append(cmnUserMst.getUserMiddleName() != null ? cmnUserMst.getUserMiddleName() + " " : "");
                lStrUserFullName.append(cmnUserMst.getUserLastName() != null ? cmnUserMst.getUserLastName() : "");


                HttpSession session = request.getSession();
                session.setAttribute("userName", lStrUserFullName.toString());
                session.setAttribute("cmnUserMst", cmnUserMst);

                return mapping.findForward("success");
            } else {
                return mapping.findForward("fail");
            }
        } catch (Exception e) {
            logger.error("Error while creating user : " + e, e);
        }
        return mapping.findForward("fail");
    }
}
