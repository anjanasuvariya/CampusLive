/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import placeComm.model.PcInterestInvitesDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class InterestInvitesDAOImpl implements InterestInvitesDAO {

    @Override
    public void saveInvitationDtls(PcInterestInvitesDtls pcInterestInvitesDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcInterestInvitesDtls.getIntDtlId()....." + pcInterestInvitesDtls.getInvtDtlId());
            if (pcInterestInvitesDtls.getInvtDtlId() != null) {
                session.update(pcInterestInvitesDtls);
            } else {
                session.save(pcInterestInvitesDtls);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PcInterestInvitesDtls getInvtDtlFromId(Long invtDtlId) throws Exception {
        List<PcInterestInvitesDtls> lLstPcInterestInvitesDtls = null;
        PcInterestInvitesDtls lObjPcInterestInvitesDtls = new PcInterestInvitesDtls();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = " from PcInterestInvitesDtls where invtDtlId =" + invtDtlId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);

            lLstPcInterestInvitesDtls = query.list();
            if (lLstPcInterestInvitesDtls != null && !lLstPcInterestInvitesDtls.isEmpty()) {
                lObjPcInterestInvitesDtls = lLstPcInterestInvitesDtls.get(0);
            }
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }

        return lObjPcInterestInvitesDtls;
    }

    @Override
    public int deleteInvtDtls(List<Long> lLstInvtDtlId) throws Exception {
        int result;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = "Delete from PcInterestInvitesDtls where invtDtlId in (:invtDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("invtDtlIdList", lLstInvtDtlId);
            result = query.executeUpdate();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public List<PcInterestInvitesDtls> getInvtList(Long lLngLoggedInUserId) throws Exception {
        List<PcInterestInvitesDtls> lLstPcInterestInvitesDtls = new ArrayList<PcInterestInvitesDtls>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
 
            String lStrQuery = "select new placeComm.model.PcInterestInvitesDtls(pid.invtDtlId,pid.companyId,"
                    + "pcd.companyTitle,pid.jobDesc,pid.lastDate,pid.jobDescDoc,pid.otherDetails) "
                    + "from PcInterestInvitesDtls pid, PcCompanyDtls pcd where pid.companyId = pcd.companyId "
                    + "and pid.createdUserId=" + lLngLoggedInUserId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);

            lLstPcInterestInvitesDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstPcInterestInvitesDtls;
    }
}
