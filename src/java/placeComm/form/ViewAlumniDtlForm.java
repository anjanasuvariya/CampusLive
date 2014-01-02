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
import placeComm.dao.AlumniDtlDAO;
import placeComm.dao.AlumniDtlDAOImpl;
import placeComm.model.PcAlumniDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewAlumniDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewAlumniDtlForm.class);
    List<PcAlumniDtls> alumniDtlList = new ArrayList<PcAlumniDtls>();
    List<ComboValueVO> comanyList = new ArrayList<ComboValueVO>();
    private String alumniDtlIds;

    public List<PcAlumniDtls> getAlumniDtlList() {
        return alumniDtlList;
    }

    public void setAlumniDtlList(List<PcAlumniDtls> alumniDtlList) {
        this.alumniDtlList = alumniDtlList;
    }

    public String getAlumniDtlIds() {
        return alumniDtlIds;
    }

    public void setAlumniDtlIds(String alumniDtlIds) {
        this.alumniDtlIds = alumniDtlIds;
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
    public ViewAlumniDtlForm() {
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
        AlumniDtlDAO lObjAlumniDtlDAO = new AlumniDtlDAOImpl();
        CommonDAO lObjCommonDAO =new CommonDAOImpl();
        try {

            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            alumniDtlList = lObjAlumniDtlDAO.getAlumniList(lObjCmnUserMst.getUserId());
            comanyList = lObjCommonDAO.getCompanyList();
            request.setAttribute("alumniDtlList", alumniDtlList);
            request.setAttribute("comanyList", comanyList);
            
        } catch (Exception e) {
            logger.error("Error while loading alumni detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
