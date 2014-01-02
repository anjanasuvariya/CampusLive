/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import common.model.CmnUserMst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import user.model.UserProjectDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserProjectDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserProjectDtlForm.class);
    List<UserProjectDtls> userProjectDtlList = new ArrayList<UserProjectDtls>();

    public List<UserProjectDtls> getUserProjectDtlList() {
        return userProjectDtlList;
    }

    public void setUserProjectDtlList(List<UserProjectDtls> userProjectDtlList) {
        this.userProjectDtlList = userProjectDtlList;
    }

    /**
     *
     */
    public UserProjectDtlForm() {
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
        SimpleDateFormat lObjSmplDtFmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String[] lStrProjName = request.getParameterValues("hdnProjName");
            String[] lStrProjRole = request.getParameterValues("hdnProjRole");
            String[] lStrProjStartDate = request.getParameterValues("hdnProjStartDate");
            String[] lStrProjEndDate = request.getParameterValues("hdnProjEndDate");
            String[] lStrOrgTeamMembers = request.getParameterValues("hdnProjTeamMembers");
            String[] lStrProjDesc = request.getParameterValues("hdnProjDesc");

            UserProjectDtls lObjUserProjectDtl = null;
            for (int lIntCnt = 0; lIntCnt < lStrProjName.length; lIntCnt++) {
                lObjUserProjectDtl = new UserProjectDtls();
                if (lStrProjName[lIntCnt] != null && !"".equals(lStrProjName[lIntCnt])) {
                    lObjUserProjectDtl.setProjName(lStrProjName[lIntCnt]);
                }
                if (lStrProjRole[lIntCnt] != null && !"".equals(lStrProjRole[lIntCnt])) {
                    lObjUserProjectDtl.setProjRole(lStrProjRole[lIntCnt]);
                }
                if (lStrProjStartDate[lIntCnt] != null && !"".equals(lStrProjStartDate[lIntCnt])) {
                    lObjUserProjectDtl.setProjStartDate((lObjSmplDtFmt.parse(lStrProjStartDate[lIntCnt])));
                }
                if (lStrProjEndDate[lIntCnt] != null && !"".equals(lStrProjEndDate[lIntCnt])) {
                    lObjUserProjectDtl.setProjEndDate((lObjSmplDtFmt.parse(lStrProjEndDate[lIntCnt])));
                }
                if (lStrOrgTeamMembers[lIntCnt] != null && !"".equals(lStrOrgTeamMembers[lIntCnt])) {
                    lObjUserProjectDtl.setProjTeamMembers(lStrOrgTeamMembers[lIntCnt]);
                }
                if (lStrProjDesc[lIntCnt] != null && !"".equals(lStrProjDesc[lIntCnt])) {
                    lObjUserProjectDtl.setProjDescription(lStrProjDesc[lIntCnt]);
                }
                userProjectDtlList.add(lObjUserProjectDtl);
            }

        } catch (Exception e) {
            logger.error("Error in user project detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
