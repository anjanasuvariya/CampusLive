/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import common.model.CmnUserMst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import placeComm.dao.StudentInterestInviteDAO;
import placeComm.dao.StudentInterestInviteDAOImpl;
import placeComm.model.StudentInterestInviteCustomVO;

/**
 *
 * @author SACHIN PATEL
 */
public class ViewStudentInterestInviteForm extends org.apache.struts.action.ActionForm {
    
    private static final Logger logger = Logger.getLogger(ViewStudentInterestInviteForm.class);
    /**
     *
     */
    public ViewStudentInterestInviteForm() {
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
        StudentInterestInviteDAO lObjStudentInterestInviteDAO = new StudentInterestInviteDAOImpl();
        List<StudentInterestInviteCustomVO> lLstStudentInterestInviteDtls = new ArrayList<StudentInterestInviteCustomVO>();
        SimpleDateFormat lObjSmplDateFrmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat lObjSmplDtFrmt = new SimpleDateFormat("dd-MMM-yyyy");
        List lLstResult = null;
        try {

            HttpSession session = request.getSession();
            CmnUserMst lObjCmnUserMst = (CmnUserMst) session.getAttribute("cmnUserMst");
            lLstResult = lObjStudentInterestInviteDAO.getStudentIntInviteDtl(lObjCmnUserMst.getUniversityId(),lObjCmnUserMst.getUserId());

            if (lLstResult != null && !lLstResult.isEmpty()) {
                for (Object obj : lLstResult) {
                    Object[] objArr = (Object[]) obj;
                    StudentInterestInviteCustomVO lObjStudentInterestInviteCustomVO = new StudentInterestInviteCustomVO();
                    if (objArr[0] != null) {
                        lObjStudentInterestInviteCustomVO.setStudInvtDtlId(Long.parseLong(objArr[0].toString()));
                    }
                    if (objArr[1] != null) {
                        lObjStudentInterestInviteCustomVO.setInvtDtlId(Long.parseLong(objArr[1].toString()));
                    }
                    if (objArr[2] != null) {
                        lObjStudentInterestInviteCustomVO.setCompanyTitle(objArr[2].toString());
                    }
                    if (objArr[3] != null) {
                        lObjStudentInterestInviteCustomVO.setJobDesc(objArr[3].toString());
                    }
                    if (objArr[4] != null) {
                        lObjStudentInterestInviteCustomVO.setJobDescDoc(objArr[4].toString());
                    }
                    if (objArr[5] != null) {
                        lObjStudentInterestInviteCustomVO.setLastDate(lObjSmplDtFrmt.format(lObjSmplDateFrmt.parse(objArr[5].toString())));
                    }
                    if (objArr[6] != null) {
                        lObjStudentInterestInviteCustomVO.setStudSelectionFlag(objArr[6].toString());
                    }

                    if (objArr[7] != null) {
                        lObjStudentInterestInviteCustomVO.setHrSelectionFlag(objArr[7].toString());
                    }
                    lLstStudentInterestInviteDtls.add(lObjStudentInterestInviteCustomVO);

                }

            }
            request.setAttribute("studentInterestInviteList", lLstStudentInterestInviteDtls);

        } catch (Exception e) {
            logger.error("Error in ViewStudentInterestInviteForm : " + e, e);
            e.printStackTrace();
        }
        return errors;
    }
}
