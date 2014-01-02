/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.model.TmpUserExcelData;
import java.util.List;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserActivationDtlDAO {
    
    List<TmpUserExcelData> getUserActivationDtls(Long lLngUniversityId) throws Exception;
    
    List<TmpUserExcelData> getUserActivationDtlsByIds(Long lLngUniversityId,List<Long> lLstActIds) throws Exception;
    
    void updateUserIdInUserExcelData(TmpUserExcelData lObjTmpUserExcelData) throws Exception;
}
