/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import common.dao.CommonDAO;
import common.dao.CommonDAOImpl;
import common.model.CmnUserMst;
import common.model.ComboValueVO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import placeComm.dao.HrDtlDAO;
import placeComm.dao.HrDtlDAOImpl;
import placeComm.model.PcHrDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewHrDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewHrDtlForm.class);
    List<PcHrDtls> hrDtlList = new ArrayList<PcHrDtls>();
    List<ComboValueVO> comanyList = new ArrayList<ComboValueVO>();
    private String hrdtlIds;

    public List<PcHrDtls> getHrDtlList() {
        return hrDtlList;
    }

    public void setHrDtlList(List<PcHrDtls> hrDtlList) {
        this.hrDtlList = hrDtlList;
    }

    public String getHrdtlIds() {
        return hrdtlIds;
    }

    public void setHrdtlIds(String hrdtlIds) {
        this.hrdtlIds = hrdtlIds;
    }

    public List<ComboValueVO> getComanyList() {
        return comanyList;
    }

    public void setComanyList(List<ComboValueVO> comanyList) {
        this.comanyList = comanyList;
    }

    /**
     *
     */
    public ViewHrDtlForm() {
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
        HrDtlDAO lObjHrDtlDAO = new HrDtlDAOImpl();
        CommonDAO lObjCommonDAO = new CommonDAOImpl();
        try {

            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            hrDtlList = lObjHrDtlDAO.getHrList(lObjCmnUserMst.getUserId());
            comanyList = lObjCommonDAO.getCompanyList();
            request.setAttribute("hrDtlList", hrDtlList);
            request.setAttribute("comanyList", comanyList);
            
        } catch (Exception e) {
            logger.error("Error while loading HR detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
