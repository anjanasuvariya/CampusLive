/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import user.model.UserPersonalDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserPersonalDtlDAOImpl implements UserPersonalDtlDAO{

    @Override
    public void saveUserPersonalDtls(UserPersonalDtls userPersonalDtl) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            System.out.println("userPersonalDtl.getPersonalDtlId....." + userPersonalDtl.getPersonalDtlId());
            if (userPersonalDtl.getPersonalDtlId() != null) {
                session.update(userPersonalDtl);
            } else {
                session.save(userPersonalDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
     @Override
    public UserPersonalDtls getUserPersonalDtl(Long lLngUserId) throws Exception {
        List<UserPersonalDtls> lLstUserPersonalDtls = new ArrayList<UserPersonalDtls>();
        UserPersonalDtls lObjUserPersonalDtls = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            //session.beginTransaction();
            String SQL_QUERY = " from UserPersonalDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + SQL_QUERY);
            Query query = session.createQuery(SQL_QUERY);
            
            lLstUserPersonalDtls = query.list();
            
            if(lLstUserPersonalDtls != null && !lLstUserPersonalDtls.isEmpty())
            {
                lObjUserPersonalDtls = lLstUserPersonalDtls.get(0);
            }
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lObjUserPersonalDtls;
    }
    
}
