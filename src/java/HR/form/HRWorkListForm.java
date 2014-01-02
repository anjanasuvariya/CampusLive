/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HR.form;

import HR.dao.HRSelectionDAO;
import HR.dao.HRSelectionDAOImpl;
import common.dao.CommonDAO;
import common.dao.CommonDAOImpl;
import common.model.CmnUserMst;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import placeComm.model.PcInterestInvitesDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class HRWorkListForm extends org.apache.struts.action.ActionForm {
    
   
    private static final Logger logger = Logger.getLogger(HRWorkListForm.class);
    /**
     *
     */
    public HRWorkListForm() {
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
        HRSelectionDAO lObjHRSelectionDAO = new HRSelectionDAOImpl();
       
        try {
            
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            List<PcInterestInvitesDtls> lLstResult = lObjHRSelectionDAO.getHrWorkList(lObjCmnUserMst.getUserId(),lObjCmnUserMst.getUniversityId());
            
            request.setAttribute("PcInterestInvtList", lLstResult);
                
        } catch (Exception e) {
            logger.error("Error while loading appointment detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
