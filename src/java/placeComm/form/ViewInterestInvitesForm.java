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
import placeComm.dao.InterestInvitesDAO;
import placeComm.dao.InterestInvitesDAOImpl;
import placeComm.model.PcInterestInvitesDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewInterestInvitesForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewInterestInvitesForm.class);
    List<PcInterestInvitesDtls> interestInvitesDtlList = new ArrayList<PcInterestInvitesDtls>();
    List<ComboValueVO> comanyList = new ArrayList<ComboValueVO>();

    /**
     *
     */
    public ViewInterestInvitesForm() {
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
        InterestInvitesDAO lObjInterestInvitesDAO = new InterestInvitesDAOImpl();
        CommonDAO lObjCommonDAO = new CommonDAOImpl();
        try {

            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            interestInvitesDtlList = lObjInterestInvitesDAO.getInvtList(lObjCmnUserMst.getUserId());
            comanyList = lObjCommonDAO.getCompanyList();
            request.setAttribute("interestInvitesDtlList", interestInvitesDtlList);
            request.setAttribute("comanyList", comanyList);

        } catch (Exception e) {
            logger.error("Error while loading interest invite detail : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
