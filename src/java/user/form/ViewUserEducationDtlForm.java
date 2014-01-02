/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

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
import user.dao.UserEducationDtlDAO;
import user.dao.UserEducationDtlDAOImpl;
import user.model.UserEducationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewUserEducationDtlForm extends org.apache.struts.action.ActionForm {

    private static final Logger logger = Logger.getLogger(ViewUserEducationDtlForm.class);
    List<UserEducationDtls> userEducationDtlList = new ArrayList<UserEducationDtls>();
    List<ComboValueVO> educationList = new ArrayList<ComboValueVO>();

    public List<UserEducationDtls> getUserEducationDtlList() {
        return userEducationDtlList;
    }

    public void setUserEducationDtlList(List<UserEducationDtls> userEducationDtlList) {
        this.userEducationDtlList = userEducationDtlList;
    }

    /**
     *
     */
    public ViewUserEducationDtlForm() {
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
        UserEducationDtlDAO lObjUserEducationDtlDAO = new UserEducationDtlDAOImpl();
        CommonDAO lObjCommonDAO = new CommonDAOImpl();
        try {
            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            userEducationDtlList = lObjUserEducationDtlDAO.getUserEducationDtls(lObjCmnUserMst.getUserId());
            educationList = lObjCommonDAO.getEducationList();
            request.setAttribute("userEducationDtlList", userEducationDtlList);
            request.setAttribute("educationList", educationList);
        } catch (Exception e) {
            logger.error("Error in view user education detail form : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
