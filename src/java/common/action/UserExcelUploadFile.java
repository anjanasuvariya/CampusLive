/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;

public class UserExcelUploadFile {
    //for getting the files path from resource bundle.
    //static ResourceBundle pathResourceBundle	=	ResourceBundle.getBundle("PathPropertyFile_en_US");

    public static Connection con = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    
    static String lStrYear = "";
    static String lStrRegisterName = "";
    static String lStrLocCode = "";
    static String lCharFlag;
    static String locationName;

    /*
     * Validates and inserts data
     * Moves files
     * Create Error log
     * 
     * */
    public static void main(String[] args) {
        try {

            String dirPath = "D://UploadAndValidateExcel";
            String successTargetPath = "D://UploadAndValidateExcel//UploadedFiles";
            String errorTargetPath = "D://UploadAndValidateExcel//ErorFiles";

            /*String dirPath = "D://UploadAndValidateExcel";
             String successTargetPath="D://UploadAndValidateExcel//UploadedFiles";*/
            String errorPathDir = "D://UploadAndValidateExcel//ErorFiles";
            String errorFilePath = "";


            String uploadFlag = "";

            String excelFileName = "";

            File[] lObjFile = finder(dirPath);
            StringBuffer query = null;

            int lIntRecordCount = 0;

            List<String> lstResult = new ArrayList<String>();
            lstResult.add("1");


            int lIntNoOfXlsFiles = lObjFile.length;
            if (lIntNoOfXlsFiles == 0) {
                System.out.println("Excel not found in the folder");
            }
            System.out.println("lIntNumOfCsvFiles: " + lIntNoOfXlsFiles);
            for (File lObjFileXls : lObjFile) {
                excelFileName = lObjFileXls.getName();
                //	System.out.println("dirPath: "+dirPath);
                System.out.println("excelFileName: " + excelFileName);
                errorFilePath = errorPathDir + "//" + excelFileName;
                errorFilePath = errorFilePath.replace(".xls", ".txt");

                String nameArray[] = excelFileName.split("_");
                String fullPath = dirPath + "//" + excelFileName;

                System.out.println("full path: " + fullPath);

                if (true) {

                    if (true) {

                        //Finally for validation and uploading

                        Map lDataMap = readExcel(fullPath);
                        if (lDataMap != null && lDataMap.size() > 0) {
                            ArrayList lInvalidDataList = lDataMap.get("inValidDataList") == null ? null : (ArrayList) lDataMap.get("inValidDataList");
                            if (lInvalidDataList != null && lInvalidDataList.size() > 0) {
                                //create error text file
                                System.out.println("Creating Error File ==>> ");

                                File lObjErrorPath = new File(errorPathDir);
                                FileUtils.copyFileToDirectory(lObjFileXls, lObjErrorPath);
                                System.out.println("Moved to Error folder");
                                lObjFileXls.delete();

                                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorFilePath), "UTF8"));
                                for (int i = 0; i < lInvalidDataList.size(); i++) {
                                    //out.append(lInvalidDataList.get(i).toString());
                                    ArrayList lErrorList = (ArrayList) lInvalidDataList.get(i);
                                    if (lErrorList != null && lErrorList.size() > 0) {
                                        for (int j = 0; j < lErrorList.size(); j++) {
                                            out.append(lErrorList.get(j).toString() + "\r\n");
                                        }
                                    }
                                }
                                out.flush();
                                out.close();

                            } else {
                                ArrayList lValidDataList = lDataMap.get("validDataList") == null ? null : (ArrayList) lDataMap.get("validDataList");
                                if (lValidDataList != null && lValidDataList.size() > 0) {
                                    System.out.println("Inserting Records in DB");
                                    Integer lCount = uploadData(lValidDataList);
//										if(lCount>0)
//										{
//											String insertTableSQL = "INSERT INTO hst_data_upload_status_track (loc_code, register_name, year, record_count, flag, created_date) VALUES (?,?,?,?,?,sysdate())";
//											con=myDbConnection();
//											preparedStatement = con.prepareStatement(insertTableSQL);
//											preparedStatement.setString(1, lStrLocCode);
//											preparedStatement.setString(2, lStrRegisterName);
//											preparedStatement.setInt(3, Integer.parseInt(lStrYear.trim()));
//											preparedStatement.setInt(4, lCount);
//											preparedStatement.setString(5, lCharFlag);
//											//preparedStatement.setTimestamp(6, getCurrentTimeStamp());
//											preparedStatement.executeUpdate();
//											close();
//	
//											File lObjSuccessPath = new File(successTargetPath);
//											FileUtils.copyFileToDirectory(lObjFileXls, lObjSuccessPath);
//											System.out.println("Moved to success folder");
//											lObjFileXls.delete();
//										}
                                }
                            }
                        } else {

                            File lObjErrorPath = new File(errorPathDir);
                            FileUtils.copyFileToDirectory(lObjFileXls, lObjErrorPath);
                            System.out.println("Moved to Error folder");
                            lObjFileXls.delete();

                            //	String outputRecordsFile = exportPdfResourceBundle.getString("exportUtilityPath")+"//RecordsTracker.txt";
                            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(errorFilePath, true)));
                            //    out.println("General Conviction Register Successfully Generated for Location: "+locNameEng);
                            out.println("Location Code is not valid");
                            out.close();
                        }
                    }
//					else
//					{
//						
//						File lObjErrorPath = new File(errorPathDir);
//						FileUtils.copyFileToDirectory(lObjFileXls, lObjErrorPath);
//						System.out.println("Moved to Error folder");
//						lObjFileXls.delete();
//
//						//	String outputRecordsFile = exportPdfResourceBundle.getString("exportUtilityPath")+"//RecordsTracker.txt";
//						PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(errorFilePath, true)));
//						//    out.println("General Conviction Register Successfully Generated for Location: "+locNameEng);
//						out.println("Excel for this Register,Location,Year and Flag is already uploaded");
//						out.close();
//					}
                } else {
                    File lObjErrorPath = new File(errorPathDir);
                    FileUtils.copyFileToDirectory(lObjFileXls, lObjErrorPath);
                    System.out.println("Moved to Error folder");
                    lObjFileXls.delete();

                    //	String outputRecordsFile = exportPdfResourceBundle.getString("exportUtilityPath")+"//RecordsTracker.txt";
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(errorFilePath, true)));
                    //    out.println("General Conviction Register Successfully Generated for Location: "+locNameEng);
                    out.println("Excel Name is not valid.");
                    out.close();

                }
                close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //For creating Connection, Added by Rahul
    public static Connection myDbConnection() {
        Connection lConn = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            String dburl = "jdbc:mysql://localhost:3306/PlaceCom";
            String dbuser = "root";
            String password = "root";
            Class.forName(driver);
            lConn = DriverManager.getConnection(dburl, dbuser, password);
        } catch (Throwable ex) {
            System.out.println("error in getConnection");
        }
        return lConn;
    }

    //For closing connection
    public static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
        }
    }
  

    //For getting files with .xls extension, Added by Rahul
    public static File[] finder(String dirName) {
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".xls");
            }
        });
    }

    //public static ResultObject readUsersExcel(Connection con)
    public static Map readExcel(String lStrFile) {
        Map opMap = new HashMap();
        ArrayList lMainList = new ArrayList();
        ArrayList lTempMainList = new ArrayList();
        try {
            WorkbookSettings workbooksetting = new WorkbookSettings();
            workbooksetting.setCellValidationDisabled(true);
            Workbook workBook = Workbook.getWorkbook(new File(lStrFile), workbooksetting);
            Sheet sheet = workBook.getSheet(0);

            System.out.println("sheet.getRows() ==>> " + sheet.getRows());

            for (int r = 1; r < sheet.getRows(); r++) {
                ArrayList lDataList = new ArrayList();
                ArrayList lTempList = new ArrayList();
                boolean isValid = true;
                boolean isRawBlank = true;
                for (int c = 0; c < 2; c++) {
                    String lStrValue = sheet.getCell(c, r).getContents().toString();

                    if (lStrValue != null && !lStrValue.trim().equalsIgnoreCase("")) {
                        isRawBlank = false;
                    }
                    lDataList.add(lStrValue);

                }
                //System.out.println("isRawBlank ====> "+isRawBlank);
                //System.out.println("isValid ====> "+isValid);
                if (!isRawBlank) {
                    if (isValid && lDataList != null && lDataList.size() > 0) {
                        lMainList.add(lDataList);
                    }
                    if (!isValid && lTempList != null && lTempList.size() > 0) {
                        lTempMainList.add(lTempList);
                    }
                }
            }
            opMap.put("inValidDataList", lTempMainList);
            opMap.put("validDataList", lMainList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opMap;
    }

     

    public static int uploadData(ArrayList lMainList) throws Exception {
        int lCount = 0;
        try {
            if (lMainList != null && lMainList.size() > 0) {
                con = myDbConnection();
                String lStrQuery = "insert into std_excel_data (roll_no,user_name) values(?,?)";
                PreparedStatement pStmt = con.prepareStatement(lStrQuery);
                con.setAutoCommit(false);

                int lTempCount = 1;
                System.out.println("lMainList.size() ==>> " + lMainList.size());

                for (int i = 0; i < lMainList.size(); i++) {
                    ArrayList lDataList = (ArrayList) lMainList.get(i);
System.out.println("lDataList.size()..."+lDataList.size());
                    if (lDataList != null && lDataList.size() > 0 && lDataList.size() == 2) {
                        pStmt.setString(1, lDataList.get(0).toString());
                        pStmt.setString(2, lDataList.get(1).toString());
                        pStmt.addBatch();
                    }
                }

                int lCnt[] = pStmt.executeBatch();
                lCount = lCnt.length;
                System.out.println("lCount ==>> " + lCount);
                con.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return lCount;
    }

   
}
