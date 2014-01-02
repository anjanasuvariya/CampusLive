/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import common.model.CmnUserMst;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONObject;
import placeComm.dao.HrDtlDAO;
import placeComm.dao.HrDtlDAOImpl;
import placeComm.form.HrDtlForm;
import placeComm.model.PcHrDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class HrDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(HrDtlAction.class);

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
        HrDtlDAO lObjHrDtlDAO = new HrDtlDAOImpl();
        PcHrDtls lObjPcHrDtl = new PcHrDtls();
        Calendar cal = Calendar.getInstance();

        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            HrDtlForm hrDtlForm = (HrDtlForm) form;

            if (hrDtlForm.getHrDtlId() != null && hrDtlForm.getHrDtlId() != 0L) {
                lObjPcHrDtl = lObjHrDtlDAO.getHrDtlFromId(hrDtlForm.getHrDtlId());

                lObjPcHrDtl.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcHrDtl.setUpdatedDate(cal.getTime());
            } else {
                lObjPcHrDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjPcHrDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcHrDtl.setCreatedDate(cal.getTime());
                //Generate activation code
                String lStrActivationCode = "HR" +lObjCmnUserMst.getUniversityId() + lObjCmnUserMst.getUserId();
                lObjPcHrDtl.setActivationCode(lStrActivationCode);
            }
            if (!"".equals(hrDtlForm.getHrName())) {
                lObjPcHrDtl.setHrName(hrDtlForm.getHrName());
            }
            if (!"".equals(hrDtlForm.getCompanyId())) {
                lObjPcHrDtl.setCompanyId(hrDtlForm.getCompanyId());
            }
            if (!"".equals(hrDtlForm.getDesignation())) {
                lObjPcHrDtl.setDesignation(hrDtlForm.getDesignation());
            }
            if (!"".equals(hrDtlForm.getHrTeleNo())) {
                lObjPcHrDtl.setHrTeleNo(hrDtlForm.getHrTeleNo());
            }
            if (!"".equals(hrDtlForm.getHrMobileNo())) {
                lObjPcHrDtl.setHrMobileNo(hrDtlForm.getHrMobileNo());
            }
            if (!"".equals(hrDtlForm.getHrEmailId())) {
                lObjPcHrDtl.setHrEmailId(hrDtlForm.getHrEmailId());
            }
            if (!"".equals(hrDtlForm.getFaxId())) {
                lObjPcHrDtl.setFaxId(hrDtlForm.getFaxId());
            }
            if (!"".equals(hrDtlForm.getAddress())) {
                lObjPcHrDtl.setAddress(hrDtlForm.getAddress());
            }
            if (!"".equals(hrDtlForm.getOtherDtls())) {
                lObjPcHrDtl.setOtherDtls(hrDtlForm.getOtherDtls());
            }
            if (!"".equals(hrDtlForm.getFacebookLink())) {
                lObjPcHrDtl.setFacebookLink(hrDtlForm.getFacebookLink());
            }
            if (!"".equals(hrDtlForm.getTwitterLink())) {
                lObjPcHrDtl.setTwitterLink(hrDtlForm.getTwitterLink());
            }
            if (!"".equals(hrDtlForm.getLinkedinLink())) {
                lObjPcHrDtl.setLinkedinLink(hrDtlForm.getLinkedinLink());
            }

            lObjHrDtlDAO.saveHrDtls(lObjPcHrDtl);

            JSONObject jsonResult = new JSONObject();
            jsonResult.put("hrDtlId", lObjPcHrDtl.getHrDtlId());
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info(jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            logger.error("Error while inserting HR detail : " + e, e);
            e.printStackTrace();
        }
        return null;

    }
}
