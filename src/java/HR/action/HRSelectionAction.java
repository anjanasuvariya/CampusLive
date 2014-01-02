/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HR.action;

import HR.dao.HRSelectionDAO;
import HR.dao.HRSelectionDAOImpl;
import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.simple.JSONObject;
import user.model.UserEducationDtls;
import user.model.UserOrganizationDtls;
import user.model.UserPersonalDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class HRSelectionAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(HRSelectionAction.class);

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
    public ActionForward approveOrRejectStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = null;
        Calendar cal = Calendar.getInstance();
        logger.info("in approveOrRejectStudent method");
        HRSelectionDAO lObjHRSelectionDAO = new HRSelectionDAOImpl();
        try {
            session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            String lStrStudInvtDtlIds = request.getParameter("studInvtDtlIds");
            String lStrHrSelectionFlag = request.getParameter("hrSelectionFlag");
            logger.info("lStrStudInvtDtlIds........." + lStrStudInvtDtlIds);
            logger.info("lStrHrSelectionFlag........." + lStrHrSelectionFlag);
            
            if(lStrStudInvtDtlIds != null && !"".equals(lStrStudInvtDtlIds))
            {
                String[] lArrStrStudInvtId = lStrStudInvtDtlIds.split("~");
                List lLstStudInvtId = new ArrayList();
                for(int lIntCnt=0;lIntCnt < lArrStrStudInvtId.length;lIntCnt++)
                {
                    lLstStudInvtId.add(lArrStrStudInvtId[lIntCnt]);
                }
                int lIntResult = lObjHRSelectionDAO.updateStudentSelectionDtl(lLstStudInvtId, lStrHrSelectionFlag,lObjCmnUserMst.getUserId(), cal.getTime());
                
            }
           
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("result", "success");
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info("jsonResult.toJSONString()...." + jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while approve or reject student : " + e, e);
        }
        return null;
    }
    
    public ActionForward getHRSelectionList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = null;
        Calendar cal = Calendar.getInstance();
        logger.info("in getHRSelectionList method");
        HRSelectionDAO lObjHRSelectionDAO = new HRSelectionDAOImpl();
        List<Long> lLstUserId = new ArrayList<Long>();
        try {
            session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            String lStrInvtDtlId = request.getParameter("InvtDtlId");
            
            logger.info("lStrInvtDtlId........." + lStrInvtDtlId);
            
            if(lStrInvtDtlId != null && !"".equals(lStrInvtDtlId))
            {
                Map<Long,List<UserEducationDtls>> lMapEducationDtl = new HashMap<Long,List<UserEducationDtls>>();
                Map<Long,List<UserOrganizationDtls>> lMapOrganizationDtl = new HashMap<Long,List<UserOrganizationDtls>>();
                List lLstResult = lObjHRSelectionDAO.getUserPersonalDtls(Long.parseLong(lStrInvtDtlId));
               
                if(lLstResult != null && !lLstResult.isEmpty())
                {
                    for(int lIntCnt=0;lIntCnt<lLstResult.size();lIntCnt++)
                    {
                        UserPersonalDtls lObjUserPersonalDtl = (UserPersonalDtls) lLstResult.get(lIntCnt);
                        
                        lLstUserId.add(lObjUserPersonalDtl.getUserId());
                    }
                }
                List<UserEducationDtls> lLstUserEducationDtl = lObjHRSelectionDAO.getUserEducationDtls(lLstUserId);
                List<UserOrganizationDtls> lLstOrganizationDtl = lObjHRSelectionDAO.getUserWorkExDtls(lLstUserId);
                for(UserEducationDtls lObjUserEducationDtl : lLstUserEducationDtl)
                {
                    if(lMapEducationDtl.get(lObjUserEducationDtl.getCreatedUserId()) != null){
                        List<UserEducationDtls> lLstUserEducation = null;
                        lLstUserEducation = lMapEducationDtl.get(lObjUserEducationDtl.getCreatedUserId());
                        lLstUserEducation.add(lObjUserEducationDtl);
                    }
                    else
                    {
                        List<UserEducationDtls> lLstUserEducation = new ArrayList<UserEducationDtls>();
                        lLstUserEducation.add(lObjUserEducationDtl);
                        lMapEducationDtl.put(lObjUserEducationDtl.getCreatedUserId(), lLstUserEducation);
                    }
                }
                for(UserOrganizationDtls lObjUserOrganizationDtl : lLstOrganizationDtl)
                {
                    if(lMapOrganizationDtl.get(lObjUserOrganizationDtl.getCreatedUserId()) != null){
                        List<UserOrganizationDtls> lLstUserOrganization = null;
                        lLstUserOrganization = lMapOrganizationDtl.get(lObjUserOrganizationDtl.getCreatedUserId());
                        lLstUserOrganization.add(lObjUserOrganizationDtl);
                    }
                    else
                    {
                        List<UserOrganizationDtls> lLstUserOrganization = new ArrayList<UserOrganizationDtls>();
                        lLstUserOrganization.add(lObjUserOrganizationDtl);
                        lMapOrganizationDtl.put(lObjUserOrganizationDtl.getCreatedUserId(), lLstUserOrganization);
                    }
                }
                
                
            }
           
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("result", "success");
            jsonResult.toJSONString();
            response.setContentType("application/json");
            logger.info("jsonResult.toJSONString()...." + jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while approve or reject student : " + e, e);
        }
        return null;
    }
}
