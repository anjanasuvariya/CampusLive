/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import common.model.CmnUserMst;
import common.helper.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

/**
 *
 * @author SACHIN PATEL
 */
public class LoginDAOImpl implements LoginDAO {

    @Override
    public List<CmnUserMst> getUserDtlFromUserNameAndPassword(String name, String password) throws Exception {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            //session.beginTransaction();
            //String SQL_QUERY = " from CmnUserMst u where u.userName='" + name + "' and u.userPassword='" + password + "'";

            String lStrQuery = " from CmnUserMst u where u.userName=:userName and u.userPassword=:password";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameter("userName", name);
            query.setParameter("password", password);
            //Iterator<CmnUserMst> it = query.iterate();
            List<CmnUserMst> lLstCmnUserMst = query.list();

            tx.commit();
            session.close();
            return lLstCmnUserMst;
        } catch (Exception e) {
            throw e;
        }
    }
}
