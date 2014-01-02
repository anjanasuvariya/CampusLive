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
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;
import placeComm.dao.StudentInterestInviteDAO;
import placeComm.dao.StudentInterestInviteDAOImpl;
import placeComm.model.PcStudentInterestInviteDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class StudentInterestInviteAction  extends DispatchAction   {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(StudentInterestInviteAction.class);

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
    public ActionForward saveStudentIntInvtDtls(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentInterestInviteDAO lObjStudentInterestInviteDAO = new StudentInterestInviteDAOImpl();
        PcStudentInterestInviteDtls lObjPcStudentInterestInviteDtls = new PcStudentInterestInviteDtls();
        HttpSession session = null;
        Calendar cal = Calendar.getInstance();     
        logger.info("in saveStudentIntInvtDtls method");
        try {
            session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            String lStrStudSelectionFlag = request.getParameter("studSelectionFlag");
            String lStrInvtDtlId = request.getParameter("intInvtId");
            String lStrAddOrUpdateFlag = request.getParameter("addOrUpdateFlag");
            logger.info("lStrStudSelectionFlag....."+lStrStudSelectionFlag);
            logger.info("lStrInvtDtlId......."+lStrInvtDtlId);
            logger.info("lStrAddOrUpdateFlag........."+lStrAddOrUpdateFlag);
            Long lLngInvtDtlId = 0L;
            if(lStrInvtDtlId != null && !"".equals(lStrInvtDtlId)){
                lLngInvtDtlId = Long.parseLong(lStrInvtDtlId);
            }

            if (lStrAddOrUpdateFlag != null && "Update".equals(lStrAddOrUpdateFlag)) {
                lObjPcStudentInterestInviteDtls = lObjStudentInterestInviteDAO.getStudInvtDtlFromInvtDtlId(lLngInvtDtlId);

                lObjPcStudentInterestInviteDtls.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcStudentInterestInviteDtls.setUpdatedDate(cal.getTime());
            } else {
                lObjPcStudentInterestInviteDtls.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcStudentInterestInviteDtls.setCreatedDate(cal.getTime());
                lObjPcStudentInterestInviteDtls.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjPcStudentInterestInviteDtls.setStudUserId(lObjCmnUserMst.getUserId());
                lObjPcStudentInterestInviteDtls.setInvtDtlId(lLngInvtDtlId);
            }
            if (lStrStudSelectionFlag != null && !"".equals(lStrStudSelectionFlag)) {
                lObjPcStudentInterestInviteDtls.setStudSelectionFlag(lStrStudSelectionFlag);
            }
            
            lObjStudentInterestInviteDAO.saveStudInvitationDtls(lObjPcStudentInterestInviteDtls);
           
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("studInvtDtlId", lObjPcStudentInterestInviteDtls.getStudInvtDtlId());
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info("jsonResult.toJSONString()...."+jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while saving interest invite details : "+e,e);
        }
        return null;
       
    }
}
