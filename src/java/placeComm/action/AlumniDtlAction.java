/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import assignment.action.AssignmentHandleAction;
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
import placeComm.dao.AlumniDtlDAO;
import placeComm.dao.AlumniDtlDAOImpl;
import placeComm.form.AlumniDtlForm;
import placeComm.model.PcAlumniDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class AlumniDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(AlumniDtlAction.class);
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
        
        AlumniDtlDAO lObjAlumniDtlDAO = new AlumniDtlDAOImpl();
        PcAlumniDtls lObjPcAlumniDtl = new PcAlumniDtls();
        Calendar cal = Calendar.getInstance();

        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            AlumniDtlForm alumniDtlForm = (AlumniDtlForm) form;

            if (alumniDtlForm.getAlumniDtlId() != null && alumniDtlForm.getAlumniDtlId() != 0L) {
                lObjPcAlumniDtl = lObjAlumniDtlDAO.getAlumniDtlFromId(alumniDtlForm.getAlumniDtlId());

                lObjPcAlumniDtl.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcAlumniDtl.setUpdatedDate(cal.getTime());
            } else {
                lObjPcAlumniDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjPcAlumniDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcAlumniDtl.setCreatedDate(cal.getTime());
            }
            if (!"".equals(alumniDtlForm.getAlumniName())) {
                lObjPcAlumniDtl.setAlumniName(alumniDtlForm.getAlumniName());
            }
            if (!"".equals(alumniDtlForm.getAlumniCompany())) {
                lObjPcAlumniDtl.setAlumniCompany(alumniDtlForm.getAlumniCompany());
            }
            if (!"".equals(alumniDtlForm.getAlumniDesignation())) {
                lObjPcAlumniDtl.setAlumniDesignation(alumniDtlForm.getAlumniDesignation());
            }
            if (!"".equals(alumniDtlForm.getAlumniBatch())) {
                lObjPcAlumniDtl.setAlumniBatch(alumniDtlForm.getAlumniBatch());
            }
            if (!"".equals(alumniDtlForm.getAlumniTelephone())) {
                lObjPcAlumniDtl.setAlumniTelephone(alumniDtlForm.getAlumniTelephone());
            }
            if (!"".equals(alumniDtlForm.getAlumniMobile())) {
                lObjPcAlumniDtl.setAlumniMobile(alumniDtlForm.getAlumniMobile());
            }
            if (!"".equals(alumniDtlForm.getAlumniEmail())) {
                lObjPcAlumniDtl.setAlumniEmail(alumniDtlForm.getAlumniEmail());
            }
            if (!"".equals(alumniDtlForm.getAlumniFax())) {
                lObjPcAlumniDtl.setAlumniFax(alumniDtlForm.getAlumniFax());
            }
            if (!"".equals(alumniDtlForm.getAlumniAddress())) {
                lObjPcAlumniDtl.setAlumniAddress(alumniDtlForm.getAlumniAddress());
            }
            if (!"".equals(alumniDtlForm.getAlumniOtherDtls())) {
                lObjPcAlumniDtl.setAlumniOtherDtls(alumniDtlForm.getAlumniOtherDtls());
            }
            if (!"".equals(alumniDtlForm.getFacebookLink())) {
                lObjPcAlumniDtl.setFacebookLink(alumniDtlForm.getFacebookLink());
            }
            if (!"".equals(alumniDtlForm.getTwitterLink())) {
                lObjPcAlumniDtl.setTwitterLink(alumniDtlForm.getTwitterLink());
            }
            if (!"".equals(alumniDtlForm.getLinkedinLink())) {
                lObjPcAlumniDtl.setLinkedinLink(alumniDtlForm.getLinkedinLink());
            }

            lObjAlumniDtlDAO.saveAlumniDtls(lObjPcAlumniDtl);

            JSONObject jsonResult = new JSONObject();
            jsonResult.put("alumniDtlId", lObjPcAlumniDtl.getAlumniDtlId());
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info(jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());
          

        } catch (Exception e) {
            logger.error("Error while inserting alumni detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
