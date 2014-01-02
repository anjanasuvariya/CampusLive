/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.action;

import common.model.CmnUserMst;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.UserContactDtlDAO;
import user.dao.UserContactDtlDAOImpl;
import user.model.UserContactDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserContactDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(ViewUserContactDtlAction.class);

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
        UserContactDtlDAO lObjUserContactDtlsDAO = new UserContactDtlDAOImpl();
        List<UserContactDtls> lLstUserContactDtls = new ArrayList<UserContactDtls>();
        UserContactDtls lObjUserContactDtls = new UserContactDtls();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");

            lLstUserContactDtls = lObjUserContactDtlsDAO.viewUserContactDtl(lObjCmnUserMst.getUserId());
            if (lLstUserContactDtls != null && !lLstUserContactDtls.isEmpty()) {

                lObjUserContactDtls = lLstUserContactDtls.get(0);
            }
            request.setAttribute("userContactDtl", lObjUserContactDtls);
        } catch (Exception e) {
            logger.error("Error view user contact detail : " + e, e);
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
