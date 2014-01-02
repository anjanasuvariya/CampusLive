/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import common.model.CmnUserMst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;
import placeComm.dao.InterestInvitesDAO;
import placeComm.dao.InterestInvitesDAOImpl;
import placeComm.form.InterestInvitesForm;
import placeComm.model.PcInterestInvitesDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class InterestInvitesAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static Logger logger = Logger.getLogger(InterestInvitesAction.class.getName());

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
    public ActionForward saveInvtDtls(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        InterestInvitesDAO lObjInterestInvitesDAO = new InterestInvitesDAOImpl();
        PcInterestInvitesDtls lObjPcInterestInvitesDtls = new PcInterestInvitesDtls();
        
      
        SimpleDateFormat lObjSmplDtFrmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        logger.info("in saveInvtDtls method");
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            InterestInvitesForm invtDtlForm = (InterestInvitesForm) form;

            if (invtDtlForm.getInvtDtlId() != null && invtDtlForm.getInvtDtlId() != 0L) {
                lObjPcInterestInvitesDtls = lObjInterestInvitesDAO.getInvtDtlFromId(invtDtlForm.getInvtDtlId());

                lObjPcInterestInvitesDtls.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcInterestInvitesDtls.setUpdatedDate(cal.getTime());
            } else {
                lObjPcInterestInvitesDtls.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcInterestInvitesDtls.setCreatedDate(cal.getTime());
                lObjPcInterestInvitesDtls.setUniversityId(lObjCmnUserMst.getUniversityId());
            }
            if (!"".equals(invtDtlForm.getCompanyId())) {
                lObjPcInterestInvitesDtls.setCompanyId(invtDtlForm.getCompanyId());
            }
            if (!"".equals(invtDtlForm.getJobDesc())) {
                lObjPcInterestInvitesDtls.setJobDesc(invtDtlForm.getJobDesc());
            }
            if (!"".equals(invtDtlForm.getLastDate())) {
                lObjPcInterestInvitesDtls.setLastDate(lObjSmplDtFrmt.parse(invtDtlForm.getLastDate()));
            }
            if (!"".equals(invtDtlForm.getJobDescDoc())) {
                lObjPcInterestInvitesDtls.setJobDescDoc(invtDtlForm.getJobDescDoc());
            }
            if (!"".equals(invtDtlForm.getOtherDetails())) {
                lObjPcInterestInvitesDtls.setOtherDetails(invtDtlForm.getOtherDetails());
            }
            lObjInterestInvitesDAO.saveInvitationDtls(lObjPcInterestInvitesDtls);
           
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("invtDtlId", lObjPcInterestInvitesDtls.getInvtDtlId());
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
    
     public ActionForward deleteInvtDtls(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
       try{
            InterestInvitesDAO lObjInterestInvitesDAO = new InterestInvitesDAOImpl();
            String lStrInvtDtlIds = request.getParameter("invtDtlIds");
            if (lStrInvtDtlIds != null && !"".equals(lStrInvtDtlIds)) {
                
                String[] lStrArrInvtDtlId = lStrInvtDtlIds.split("~");
                List<Long> lLstInvtDtlId = new ArrayList<Long>();
                for (int lIntCnt = 0; lIntCnt < lStrArrInvtDtlId.length; lIntCnt++) {
                  
                    lLstInvtDtlId.add(Long.parseLong(lStrArrInvtDtlId[lIntCnt]));
                }
                int lIntResult = lObjInterestInvitesDAO.deleteInvtDtls(lLstInvtDtlId);
                
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("result", lIntResult);
                jsonResult.toJSONString();
                response.setContentType("application/json");
                response.getWriter().write(jsonResult.toJSONString());
            }
            
        }
        catch(Exception e){
                e.printStackTrace();
                logger.error("Error while deleting interest invite details : "+e,e);
            }
        return null;
    }
}
