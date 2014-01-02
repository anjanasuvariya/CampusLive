/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONObject;
import placeComm.dao.AppointmentDtlDAO;
import placeComm.dao.AppointmentDtlDAOImpl;
import placeComm.form.ViewAppointmentDtlForm;

/**
 *
 * @author SACHIN PATEL
 */
public class DeleteAppointmentDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(DeleteAppointmentDtlAction.class);

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

        try {
            AppointmentDtlDAO lObjAppointmentDtlDAO = new AppointmentDtlDAOImpl();
            ViewAppointmentDtlForm viewAppointmentDtlForm = (ViewAppointmentDtlForm) form;
            if (viewAppointmentDtlForm.getAppntDtlIds() != null && !"".equals(viewAppointmentDtlForm.getAppntDtlIds())) {

                String[] lStrAppntDtlIds = viewAppointmentDtlForm.getAppntDtlIds().split("~");
                List<Long> lLstAppntDtlId = new ArrayList<Long>();
                for (int lIntCnt = 0; lIntCnt < lStrAppntDtlIds.length; lIntCnt++) {

                    lLstAppntDtlId.add(Long.parseLong(lStrAppntDtlIds[lIntCnt]));
                }
                int lIntResult = lObjAppointmentDtlDAO.deleteAppntHistory(lLstAppntDtlId);
                lIntResult = lObjAppointmentDtlDAO.deleteAppntDtls(lLstAppntDtlId);
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("result", lIntResult);
                jsonResult.toJSONString();
                response.setContentType("application/json");
                response.getWriter().write(jsonResult.toJSONString());
            }

        } catch (Exception e) {
            logger.error("Error while deleting appointment detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
