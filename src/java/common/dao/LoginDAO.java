/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import java.util.List;
import common.model.CmnUserMst;

/**
 *
 * @author SACHIN PATEL
 */
public interface LoginDAO {
    
    public List<CmnUserMst> getUserDtlFromUserNameAndPassword(String name, String password) throws Exception;
}
