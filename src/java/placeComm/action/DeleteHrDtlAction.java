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
import placeComm.dao.HrDtlDAO;
import placeComm.dao.HrDtlDAOImpl;
import placeComm.form.ViewHrDtlForm;

/**
 *
 * @author SACHIN PATEL
 */
public class DeleteHrDtlAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(DeleteHrDtlAction.class);

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
            HrDtlDAO lObjHrDtlDAO = new HrDtlDAOImpl();
            ViewHrDtlForm viewHrDtlForm = (ViewHrDtlForm) form;
            if (viewHrDtlForm.getHrdtlIds() != null && !"".equals(viewHrDtlForm.getHrdtlIds())) {

                String[] lStrHrDtlIds = viewHrDtlForm.getHrdtlIds().split("~");
                List<Long> lLstHrDtlId = new ArrayList<Long>();
                for (int lIntCnt = 0; lIntCnt < lStrHrDtlIds.length; lIntCnt++) {

                    lLstHrDtlId.add(Long.parseLong(lStrHrDtlIds[lIntCnt]));
                }
                int lIntResult = lObjHrDtlDAO.deleteHrDtls(lLstHrDtlId);
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("result", lIntResult);
                jsonResult.toJSONString();
                response.setContentType("application/json");
                response.getWriter().write(jsonResult.toJSONString());
            }

        } catch (Exception e) {
            logger.error("Error while deleting HR detail : " + e, e);
            e.printStackTrace();
        }
        return null;
    }
}
