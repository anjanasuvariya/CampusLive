/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import user.model.UserContactDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class UserContactDtlDAOImpl implements UserContactDtlDAO {

    @Override
    public void saveUserContactDtls(UserContactDtls userContactDtl) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            System.out.println("userContactDtl.getUserContactId....." + userContactDtl.getUserContactId());
            if (userContactDtl.getUserContactId() != null) {
                session.update(userContactDtl);
            } else {
                session.save(userContactDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserContactDtls> viewUserContactDtl(Long lLngUserId) throws Exception {
        List<UserContactDtls> lLstUserContactDtls = new ArrayList<UserContactDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            //session.beginTransaction();
            String SQL_QUERY = " from UserContactDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + SQL_QUERY);
            Query query = session.createQuery(SQL_QUERY);
            
            lLstUserContactDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserContactDtls;
    }
}
