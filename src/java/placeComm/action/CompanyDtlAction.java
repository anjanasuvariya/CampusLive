/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import common.model.CmnUserMst;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONObject;
import placeComm.dao.CompanyDtlDAO;
import placeComm.dao.CompanyDtlDAOImpl;
import placeComm.form.CompanyDtlForm;
import placeComm.model.PcCompanyDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class CompanyDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    private static final Logger logger = Logger.getLogger(CompanyDtlAction.class);

 
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
        CompanyDtlDAO lObjCompanyDtlDAO = new CompanyDtlDAOImpl();
        PcCompanyDtls lObjPcCompanyDtl = new PcCompanyDtls();
        Calendar cal = Calendar.getInstance();
        logger.info("Anjana in CompanyDtlAction");  
        try
        {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            
            CompanyDtlForm companyDtlForm = (CompanyDtlForm) form;
            
            if (companyDtlForm.getCompanyId() != null && companyDtlForm.getCompanyId() != 0L) {
                lObjPcCompanyDtl = lObjCompanyDtlDAO.getCompanyDtlFromId(companyDtlForm.getCompanyId());
                
                lObjPcCompanyDtl.setUpdatedUserId(lObjCmnUserMst.getUserId());
                lObjPcCompanyDtl.setUpdatedDate(cal.getTime());
            }
            else
            {
                lObjPcCompanyDtl.setUniversityId(lObjCmnUserMst.getUniversityId());
                lObjPcCompanyDtl.setCreatedUserId(lObjCmnUserMst.getUserId());
                lObjPcCompanyDtl.setCreatedDate(cal.getTime());
            }
            if(!"".equals(companyDtlForm.getCompanyTitle())) {
                lObjPcCompanyDtl.setCompanyTitle(companyDtlForm.getCompanyTitle());
            }
            if(!"".equals(companyDtlForm.getCompanyCode())) {
                lObjPcCompanyDtl.setCompanyCode(companyDtlForm.getCompanyCode());
            }
            if(!"".equals(companyDtlForm.getContactPersonName())) {
                lObjPcCompanyDtl.setContactPersonName(companyDtlForm.getContactPersonName());
            }
            if(!"".equals(companyDtlForm.getContactNumber())) {
                lObjPcCompanyDtl.setContactNumber(companyDtlForm.getContactNumber());
            }
            if(!"".equals(companyDtlForm.getContactAddress())) {
                lObjPcCompanyDtl.setContactAddress(companyDtlForm.getContactAddress());
            }
            if(!"".equals(companyDtlForm.getContactEmail())) {
                lObjPcCompanyDtl.setContactEmail(companyDtlForm.getContactEmail());
            }
            if(!"".equals(companyDtlForm.getCompanyLocation())) {
                lObjPcCompanyDtl.setCompanyLocation(companyDtlForm.getCompanyLocation());
            }
            if(!"".equals(companyDtlForm.getCompanyPriority())) {
                lObjPcCompanyDtl.setCompanyPriority(companyDtlForm.getCompanyPriority());
            }
         
            
            
            lObjCompanyDtlDAO.saveCompanyDtls(lObjPcCompanyDtl);
            
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("companyId", lObjPcCompanyDtl.getCompanyId());
            jsonResult.toJSONString();
            response.setContentType("application/json");
            System.out.println(jsonResult.toJSONString().toString());
            response.getWriter().write(jsonResult.toJSONString());
           
            return null;
                  
        }
        catch(Exception e)
        {
            logger.error("Error while saving company details : "+e,e);
            e.printStackTrace();
        }
        return null;
       
    }
}
