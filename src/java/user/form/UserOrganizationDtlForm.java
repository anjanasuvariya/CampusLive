/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserOrganizationDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserOrganizationDtlForm.class);
    List<UserOrganizationDtls> userOrganizationDtlList = new ArrayList<UserOrganizationDtls>();

    public List<UserOrganizationDtls> getUserOrganizationDtlList() {
        return userOrganizationDtlList;
    }

    public void setUserOrganizationDtlList(List<UserOrganizationDtls> userOrganizationDtlList) {
        this.userOrganizationDtlList = userOrganizationDtlList;
    }

    /**
     *
     */
    public UserOrganizationDtlForm() {
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
        try {
            String[] lStrOrgName = request.getParameterValues("hdnOrgName");
            String[] lStrOrgTitle = request.getParameterValues("hdnOrgTitle");
            String[] lStrOrgStartMonth = request.getParameterValues("hdnOrgStartMonth");
            String[] lStrOrgStartYear = request.getParameterValues("hdnOrgStartYear");
            String[] lStrOrgEndMonth = request.getParameterValues("hdnOrgEndMonth");
            String[] lStrOrgEndYear = request.getParameterValues("hdnOrgEndYear");
            String[] lStrOrgWorkExArea = request.getParameterValues("hdnOrgWorkExArea");
            String[] lStrOrgLocation = request.getParameterValues("hdnOrgLocation");
            String[] lStrOrgDescription = request.getParameterValues("hdnOrgDesc");

            UserOrganizationDtls lObjUserOrganizationDtl = null;
            for (int lIntCnt = 0; lIntCnt < lStrOrgName.length; lIntCnt++) {
                lObjUserOrganizationDtl = new UserOrganizationDtls();
                if (lStrOrgName[lIntCnt] != null && !"".equals(lStrOrgName[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgName(lStrOrgName[lIntCnt]);
                }
                if (lStrOrgTitle[lIntCnt] != null && !"".equals(lStrOrgTitle[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgTitle(lStrOrgTitle[lIntCnt]);
                }
                if (lStrOrgStartMonth[lIntCnt] != null && !"".equals(lStrOrgStartMonth[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgStartMonth(Integer.parseInt(lStrOrgStartMonth[lIntCnt]));
                }
                if (lStrOrgStartYear[lIntCnt] != null && !"".equals(lStrOrgStartYear[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgStartYear(Integer.parseInt(lStrOrgStartYear[lIntCnt]));
                }
                if (lStrOrgEndMonth[lIntCnt] != null && !"".equals(lStrOrgEndMonth[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgEndMonth(Integer.parseInt(lStrOrgEndMonth[lIntCnt]));
                }
                if (lStrOrgEndYear[lIntCnt] != null && !"".equals(lStrOrgEndYear[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgEndYear(Integer.parseInt(lStrOrgEndYear[lIntCnt]));
                }
                if (lStrOrgWorkExArea[lIntCnt] != null && !"".equals(lStrOrgWorkExArea[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgWorkExArea(lStrOrgWorkExArea[lIntCnt]);
                }
                if (lStrOrgLocation[lIntCnt] != null && !"".equals(lStrOrgLocation[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgLocation(lStrOrgLocation[lIntCnt]);
                }
                if (lStrOrgDescription[lIntCnt] != null && !"".equals(lStrOrgDescription[lIntCnt])) {
                    lObjUserOrganizationDtl.setOrgDescription(lStrOrgDescription[lIntCnt]);
                }
                userOrganizationDtlList.add(lObjUserOrganizationDtl);
            }

        } catch (Exception e) {
            logger.error("Error in user organization detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
