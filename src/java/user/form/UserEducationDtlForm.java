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
import user.model.UserEducationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserEducationDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(UserEducationDtlForm.class);
    List<UserEducationDtls> userEducationDtlList = new ArrayList<UserEducationDtls>();

    public List<UserEducationDtls> getUserEducationDtlList() {
        return userEducationDtlList;
    }

    public void setUserEducationDtlList(List<UserEducationDtls> userEducationDtlList) {
        this.userEducationDtlList = userEducationDtlList;
    }

    /**
     *
     */
    public UserEducationDtlForm() {
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
            String[] lStrName = request.getParameterValues("hdnName");
            String[] lStrCity = request.getParameterValues("hdnCity");
            String[] lStrFromYear = request.getParameterValues("hdnFromYear");
            String[] lStrToYear = request.getParameterValues("hdnToYear");
            String[] lStrSpecialization = request.getParameterValues("hdnSpecialization");
            String[] lStrTitle = request.getParameterValues("hdnTitle");
            String[] lStrMajor = request.getParameterValues("hdnMajor");
            String[] lStrMinorMajor = request.getParameterValues("hdnMinorMajor");
            String[] lStrPercentage = request.getParameterValues("hdnPercentage");

            UserEducationDtls lObjUserEducationDtl = null;
            if(lStrName != null && lStrName.length >0) {
               for (int lIntCnt = 0; lIntCnt < lStrName.length; lIntCnt++) {
                lObjUserEducationDtl = new UserEducationDtls();
                if (!"".equals(lStrName[lIntCnt])) {
                    lObjUserEducationDtl.setSchoolCollegeName(lStrName[lIntCnt]);
                }
                if (!"".equals(lStrCity[lIntCnt])) {
                    lObjUserEducationDtl.setSchoolCollegeCity(lStrCity[lIntCnt]);
                }
                if (!"".equals(lStrFromYear[lIntCnt])) {
                    lObjUserEducationDtl.setSchoolCollegeFromYear(Long.parseLong(lStrFromYear[lIntCnt]));
                }
                if (!"".equals(lStrToYear[lIntCnt])) {
                    lObjUserEducationDtl.setSchoolCollegeToYear(Long.parseLong(lStrToYear[lIntCnt]));
                }
                if (!"".equals(lStrSpecialization[lIntCnt])) {
                    lObjUserEducationDtl.setSpecialization(lStrSpecialization[lIntCnt]);
                }
                if (!"".equals(lStrTitle[lIntCnt])) {
                    lObjUserEducationDtl.setGraduationMasterTitle(lStrTitle[lIntCnt]);
                }
                if (!"".equals(lStrMajor[lIntCnt])) {
                    lObjUserEducationDtl.setMajorSubject(lStrMajor[lIntCnt]);
                }
                if (!"".equals(lStrMinorMajor[lIntCnt])) {
                    lObjUserEducationDtl.setOtherMinorMajorSubject(lStrMinorMajor[lIntCnt]);
                }
                if (!"".equals(lStrPercentage[lIntCnt])) {
                    lObjUserEducationDtl.setPercentage(Double.parseDouble(lStrPercentage[lIntCnt]));
                }
                userEducationDtlList.add(lObjUserEducationDtl);
              }
            }
            else
            {
                errors.add("name", new ActionMessage("error.collegeName.required"));
            }
            
        } catch (Exception e) {
            logger.error("Error in user education detail form : " + e, e);
            e.printStackTrace();
        }

        return errors;
    }
}
