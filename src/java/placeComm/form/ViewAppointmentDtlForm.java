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
import placeComm.dao.AppointmentDtlDAO;
import placeComm.dao.AppointmentDtlDAOImpl;
import placeComm.model.AppointmentCustomVO;


/**
 *
 * @author SACHIN PATEL
 */
public class ViewAppointmentDtlForm extends org.apache.struts.action.ActionForm {
    
    private static final Logger logger = Logger.getLogger(ViewAppointmentDtlForm.class);
    List<AppointmentCustomVO> appntDtlList = new ArrayList<AppointmentCustomVO>();
    private String appntDtlIds;
    List<ComboValueVO> comanyList = new ArrayList<ComboValueVO>();
    List<ComboValueVO> placeCommMemList = new ArrayList<ComboValueVO>();

    public List<AppointmentCustomVO> getAppntDtlList() {
        return appntDtlList;
    }

    public void setAppntDtlList(List<AppointmentCustomVO> appntDtlList) {
        this.appntDtlList = appntDtlList;
    }

    public String getAppntDtlIds() {
        return appntDtlIds;
    }

    public void setAppntDtlIds(String appntDtlIds) {
        this.appntDtlIds = appntDtlIds;
    }

    public List<ComboValueVO> getComanyList() {
        return comanyList;
    }

    public void setComanyList(List<ComboValueVO> comanyList) {
        this.comanyList = comanyList;
    }

    public List<ComboValueVO> getPlaceCommMemList() {
        return placeCommMemList;
    }

    public void setPlaceCommMemList(List<ComboValueVO> placeCommMemList) {
        this.placeCommMemList = placeCommMemList;
    }

    

    /**
     *
     */
    public ViewAppointmentDtlForm() {
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
        AppointmentDtlDAO lObjAppointmentDtlDAO = new AppointmentDtlDAOImpl();
        CommonDAO lObjCommonDAO =new CommonDAOImpl();
        try {
            
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            appntDtlList = lObjAppointmentDtlDAO.getAppointmentList(lObjCmnUserMst.getUserId());
            comanyList = lObjCommonDAO.getCompanyList();
            placeCommMemList = lObjCommonDAO.getPlaceCommMemberList(lObjCmnUserMst.getUniversityId(), 5L);
            request.setAttribute("appntDtlList", appntDtlList);
            request.setAttribute("comanyList", comanyList);
            request.setAttribute("placeCommMemList", placeCommMemList);
            
        } catch (Exception e) {
            logger.error("Error while loading appointment detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
