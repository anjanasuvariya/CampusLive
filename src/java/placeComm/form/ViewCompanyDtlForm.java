/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.json.simple.JSONObject;
import placeComm.dao.CompanyDtlDAO;
import placeComm.dao.CompanyDtlDAOImpl;
import placeComm.model.PcCompanyDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewCompanyDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewCompanyDtlForm.class);
    private String companyIds;
    List<PcCompanyDtls> companyDtlList = new ArrayList<PcCompanyDtls>();

    public List<PcCompanyDtls> getCompanyDtlList() {
        return companyDtlList;
    }

    public void setCompanyDtlList(List<PcCompanyDtls> companyDtlList) {
        this.companyDtlList = companyDtlList;
    }

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    /**
     *
     */
    public ViewCompanyDtlForm() {
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
        CompanyDtlDAO lObjCompanyDtlDAO = new CompanyDtlDAOImpl();
        try {
            
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            companyDtlList = lObjCompanyDtlDAO.getCompanyList(lObjCmnUserMst.getUserId());
            request.setAttribute("companyDtlList", companyDtlList);
        } catch (Exception e) {
            logger.error("Error while loading company detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
