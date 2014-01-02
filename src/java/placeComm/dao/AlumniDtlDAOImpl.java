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
import placeComm.model.PcAlumniDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class AlumniDtlDAOImpl implements AlumniDtlDAO{

    @Override
    public void saveAlumniDtls(PcAlumniDtls pcAlumniDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcAlumniDtl.getAlumniDtlId()....." + pcAlumniDtl.getAlumniDtlId());
            if (pcAlumniDtl.getAlumniDtlId() != null) {
                session.update(pcAlumniDtl);
            } else {
                session.save(pcAlumniDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PcAlumniDtls getAlumniDtlFromId(Long alumniDtlId) throws Exception {
       List<PcAlumniDtls> lLstPcAlumniDtls = null;
        PcAlumniDtls lObjPcAlumniDtl = new PcAlumniDtls();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcAlumniDtls where alumniDtlId=" + alumniDtlId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcAlumniDtls = query.list();
            if(lLstPcAlumniDtls != null && !lLstPcAlumniDtls.isEmpty())
            {
                lObjPcAlumniDtl = lLstPcAlumniDtls.get(0);
            }
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lObjPcAlumniDtl;
    }

    @Override
    public List<PcAlumniDtls> getAlumniList(Long lLngLoggedInUserId) throws Exception {
         List<PcAlumniDtls> lLstPcAlumniDtls = new ArrayList<PcAlumniDtls>();
       
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcAlumniDtls where createdUserId=" + lLngLoggedInUserId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcAlumniDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstPcAlumniDtls;
    }

    @Override
    public int deleteAlumniDtls(List<Long> lLstAlumniDtlId) throws Exception {
         int result;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "Delete from PcAlumniDtls where alumniDtlId in (:alumniDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("alumniDtlIdList", lLstAlumniDtlId);
            result = query.executeUpdate();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
}
