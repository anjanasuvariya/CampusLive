/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import common.helper.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import placeComm.model.PcInterestInvitesDtls;
import placeComm.model.PcStudentInterestInviteDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class StudentInterestInviteDAOImpl implements StudentInterestInviteDAO {

    @Override
    public List getStudentIntInviteDtl(Long lLngUniversityId,Long lLngLoggerInUserId) throws Exception {
        List lLstStudentIntInviteDtl = new ArrayList();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = "select psd.stud_invt_dtl_id,pcd.invt_dtl_id,com.company_title,pcd.job_desc,pcd.job_desc_doc,"
                    + "pcd.last_date,psd.stud_selection_flag,psd.hr_selection_flag from pc_interest_invites_dtls pcd "
                    + "left outer join pc_student_interest_invite_dtls psd on pcd.invt_dtl_id = psd.invt_dtl_id and psd.stud_user_id = :loggedInUserId "
                    + "join pc_company_dtls com on pcd.company_id = com.company_id where pcd.university_id = :univeristyId";

            System.out.println("Query======" + lStrQuery);
            Query query = session.createSQLQuery(lStrQuery);
            query.setParameter("univeristyId", lLngUniversityId);
            query.setParameter("loggedInUserId",lLngLoggerInUserId);
            
            lLstStudentIntInviteDtl = query.list();
            tx.commit();
            //session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstStudentIntInviteDtl;
    }

    @Override
    public void saveStudInvitationDtls(PcStudentInterestInviteDtls pcStudentInterestInviteDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcStudentInterestInviteDtl.getStudInvtDtlId()....." + pcStudentInterestInviteDtl.getStudInvtDtlId());
            if (pcStudentInterestInviteDtl.getStudInvtDtlId() != null) {
                session.update(pcStudentInterestInviteDtl);
            } else {
                session.save(pcStudentInterestInviteDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PcStudentInterestInviteDtls getStudInvtDtlFromInvtDtlId(Long lLngIntInvtDtlId) throws Exception {
        List<PcStudentInterestInviteDtls> lLstPcStudentInterestInviteDtls = null;
        PcStudentInterestInviteDtls lObjPcStudentInterestInviteDtls = new PcStudentInterestInviteDtls();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = " from PcStudentInterestInviteDtls where invtDtlId =" + lLngIntInvtDtlId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);

            lLstPcStudentInterestInviteDtls = query.list();
            if (lLstPcStudentInterestInviteDtls != null && !lLstPcStudentInterestInviteDtls.isEmpty()) {
                lObjPcStudentInterestInviteDtls = lLstPcStudentInterestInviteDtls.get(0);
            }
            tx.commit();
            //session.close();

        } catch (Exception e) {
             //session.close();
            throw e;
        }
        finally{
             //session.close();
        }

        return lObjPcStudentInterestInviteDtls;
    }
}
