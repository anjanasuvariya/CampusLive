/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import com.google.gson.Gson;
import common.model.CmnUserMst;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import placeComm.dao.AppointmentDtlDAO;
import placeComm.dao.AppointmentDtlDAOImpl;
import placeComm.form.AppointmentDtlForm;
import placeComm.form.ViewAppointmentDtlForm;
import placeComm.model.AppointmentCustomVO;
import placeComm.model.HstAppointmentDtls;
import placeComm.model.PcAppointmentDtls;
import org.apache.log4j.Logger;

/**
 *
 * @author SACHIN PATEL
 */
public class AppointmentDtlAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static Logger logger = Logger.getLogger(AppointmentDtlAction.class.getName());

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
    public ActionForward saveAppointmentDtls(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Here it is " + request.getAttribute("uploadFile").getClass().getName());
        
        AppointmentDtlDAO lObjAppointmentDtlDAO = new AppointmentDtlDAOImpl();
        PcAppointmentDtls lObjPcAppointmentDtl = new PcAppointmentDtls();
        HstAppointmentDtls lObjHstAppointmentDtls = new HstAppointmentDtls();
        Calendar cal = Calendar.getInstance();
        logger.info("in save appointment method");
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            AppointmentDtlForm appntDtlForm = (AppointmentDtlForm) form;

            if (appntDtlForm.getAppntDtlId() != null && appntDtlForm.getAppntDtlId() != 0L) {
                lObjPcAppointmentDtl = lObjAppointmentDtlDAO.getAppntDtlFromId(appntDtlForm.getAppntDtlId());

                lObjPcAppointmentDtl.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcAppointmentDtl.setUpdatedDate(cal.getTime());
            } else {
                lObjPcAppointmentDtl.setOwnerId(lObjCmnUserMst.getUserId());
                lObjPcAppointmentDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcAppointmentDtl.setCreatedDate(cal.getTime());
                lObjPcAppointmentDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjHstAppointmentDtls.setUserId(lObjCmnUserMst.getUserId());
                lObjHstAppointmentDtls.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjHstAppointmentDtls.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjHstAppointmentDtls.setCreatedDate(cal.getTime());
            }
            if (!"".equals(appntDtlForm.getAppntTitle())) {
                lObjPcAppointmentDtl.setAppntTitle(appntDtlForm.getAppntTitle());
            }
            if (!"".equals(appntDtlForm.getAppntPurpose())) {
                lObjPcAppointmentDtl.setAppntPurpose(appntDtlForm.getAppntPurpose());
            }
            if (!"".equals(appntDtlForm.getAppntFileName())) {
                lObjPcAppointmentDtl.setAppntFileName(appntDtlForm.getAppntFileName());
            }
            if (!"".equals(appntDtlForm.getAppntCompany())) {
                lObjPcAppointmentDtl.setAppntCompany(appntDtlForm.getAppntCompany());
            }
            if (!"".equals(appntDtlForm.getAssignedTo())) {
                lObjPcAppointmentDtl.setAssignedTo(appntDtlForm.getAssignedTo());
            }
            if (appntDtlForm.getAppntDtlId() == null || appntDtlForm.getAppntDtlId() == 0L) {
                if (!"".equals(appntDtlForm.getAppntStatus())) {
                    lObjHstAppointmentDtls.setStatus(appntDtlForm.getAppntStatus());
                }

                if (!"".equals(appntDtlForm.getAppntMessage())) {
                    lObjHstAppointmentDtls.setMessage(appntDtlForm.getAppntMessage());
                }
            }
            if (!"".equals(appntDtlForm.getAppntPriority())) {
                lObjPcAppointmentDtl.setAppntPriority(appntDtlForm.getAppntPriority());
            }


            lObjAppointmentDtlDAO.saveAppointmentDtls(lObjPcAppointmentDtl);
            if (appntDtlForm.getAppntDtlId() == null || appntDtlForm.getAppntDtlId() == 0L) {
                lObjHstAppointmentDtls.setAppntDtlId(lObjPcAppointmentDtl.getAppntDtlId());
                lObjAppointmentDtlDAO.saveAppntHstDtls(lObjHstAppointmentDtls);
            }

            JSONObject jsonResult = new JSONObject();
            jsonResult.put("appntDtlId", lObjPcAppointmentDtl.getAppntDtlId());
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info("jsonResult.toJSONString()...."+jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            logger.error("Error while inserting appoinement detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }

    public ActionForward viewAppntHistory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            AppointmentDtlDAO lObjAppointmentDtlDAO = new AppointmentDtlDAOImpl();
            List<AppointmentCustomVO> appointmentHst = new ArrayList<AppointmentCustomVO>();
            String lStrAppntDtlId = request.getParameter("appntDtlId");
            if (lStrAppntDtlId != null && !"".equals(lStrAppntDtlId)) {
                appointmentHst = lObjAppointmentDtlDAO.getApptHstByAppntId(Long.parseLong(lStrAppntDtlId));
            }

            Gson gson = new Gson();
            String json = gson.toJson(appointmentHst);
            logger.info("json....."+json);
            response.getWriter().write(json);


        } catch (Exception e) {
             logger.error("Error while view appoinement history : " + e, e);
            e.printStackTrace();
        }
        return null;

    }

    public ActionForward saveAppntHstDtls(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        AppointmentDtlDAO lObjAppointmentDtlDAO = new AppointmentDtlDAOImpl();
        HstAppointmentDtls lObjHstAppointmentDtls = new HstAppointmentDtls();
        Calendar cal = Calendar.getInstance();

        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            String lStrHstAppntDtlId = request.getParameter("hstAppntDtlId");
            String lStrAppntDtlId = request.getParameter("appntDtlId");
            // String lStrUserId = request.getParameter("userId");
            String lStrMessage = request.getParameter("message");
            String lStrStatus = request.getParameter("status");


            if (lStrHstAppntDtlId != null && !"".equals(lStrHstAppntDtlId)) {
                lObjHstAppointmentDtls = lObjAppointmentDtlDAO.getHstAppntDtlFromId(Long.parseLong(lStrHstAppntDtlId));
                
                lObjHstAppointmentDtls.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjHstAppointmentDtls.setUpdatedDate(cal.getTime());
            } else {

                if (lStrAppntDtlId != null && !"".equals(lStrAppntDtlId)) {
                    lObjHstAppointmentDtls.setAppntDtlId(Long.parseLong(lStrAppntDtlId));
                }

                lObjHstAppointmentDtls.setUserId(lObjCmnUserMst.getUserId());
                lObjHstAppointmentDtls.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjHstAppointmentDtls.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjHstAppointmentDtls.setCreatedDate(cal.getTime());

            }

            if (lStrMessage != null && !"".equals(lStrMessage)) {
                lObjHstAppointmentDtls.setMessage(lStrMessage);
            }
            if (!"".equals(lStrStatus)) {
                lObjHstAppointmentDtls.setStatus(lStrStatus);
            }

            lObjHstAppointmentDtls.setHstAppntDtlId(Long.parseLong(lStrHstAppntDtlId)); // Added by Jyot, It was coming NULL
            lObjAppointmentDtlDAO.saveAppntHstDtls(lObjHstAppointmentDtls);

            JSONObject jsonResult = new JSONObject();
            jsonResult.put("hstAppntDtlId", lObjHstAppointmentDtls.getHstAppntDtlId());

            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info("jsonResult.toJSONString()......"+jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            logger.error("Error while save appoinement history details : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
