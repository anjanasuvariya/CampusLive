/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author SACHIN PATEL
 */
public class LogOutAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(LogOutAction.class);
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
        try{
            HttpSession session = request.getSession();
            session.removeAttribute("userName");
            session.removeAttribute("cmnUserMst");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.error("Error while logout : " + e, e);
        }
        return mapping.findForward(SUCCESS);
    }
}
