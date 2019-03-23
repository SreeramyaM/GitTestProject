package org.fwcms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;

public class MySqlAccess {
	
	private static final Logger logger = LogManager.getLogger(MySqlAccess.class.getName());
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet  = null;
	
	public String getOtpOfUser(String userName){
		String otp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select OTP_PSSWRD_TX from USR_LKUP where USER_NAME = '"+userName+"'");
			if(resultSet!=null){
				resultSet.next();
			}
			return resultSet.getString("OTP_PSSWRD_TX");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			close();
		}
		return otp;
	}
	
	public int getUserId(String userName) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select USR_ID from USR_LKUP where USER_NAME = '"+userName+"'");
			if(resultSet!=null){
				resultSet.next();
			}
			
			return resultSet.getInt(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Could Not fetch User Id for user "+userName+ " "+e.getMessage());
		}finally{
			close();
		}
	}
	
	private void close(){
		try {
			if(resultSet!=null){
				resultSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connect!=null){
				connect.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	

	public String createMykadNumber(String Mykad,String emailAddress, String phoneNumber)
	{
		try {
			Random randomGenerator = new Random();
			int orgRegNumber=randomGenerator.nextInt(1000000);
			Random ran  = new Random();
			int nameValue =ran.nextInt(10000);
			String orgname="FWCMSAUTO"+nameValue;
			System.out.println("Org_NM is : "+orgname);
			
			Date date = new Date();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String currentDate= sdf.format(date);
			System.out.println(currentDate);
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			String org_reg_number=orgRegNumber+"-FW";
			statement.execute("INSERT INTO `EMPLYR_REG_DTL` (`ORG_REG_NR`, `ORG_NM`, `ORG_TYPE`,`SEC_NM`,`BLK_LIST_IND`,`EMP_STAT_CD`, `CRT_TS`, `MOD_TS`, `CRT_USR_ID`,`MOD_USR_ID`) VALUES( '"+orgRegNumber+"-FW', '"+orgname+"', 'S', 'NULL', '0', 'ACTIVE' , NULL, NULL, NULL, NULL);");
			resultSet = statement.executeQuery("select last_insert_id() as last_id from EMPLYR_REG_DTL");
			resultSet.next();
			String empRegisterDetailID=resultSet.getString("last_id");
			System.out.println(empRegisterDetailID);
			int empRegDetailID=Integer.parseInt(empRegisterDetailID);
			
			statement.execute("INSERT INTO `USR_LKUP` (`USR_FULL_NM`, `ADDR_TX`, `EMAIL_ID`, `CNTCT_PHN_NR`, `BRTH_DT`, `USER_NAME`, `STAT_CD`, `OTP_PSSWRD_TX`, `OTP_GNRTD_TS`, `MT_DT_MSTR_ID`, `CRT_TS`, `MOD_TS`, `CRT_USR_ID`, `MOD_USR_ID`, `CHNG_RSN_TX`, `FIRST_LOGIN_FLAG`) VALUES('auremployer', '"+orgname+"', '"+emailAddress+"', '+60"+phoneNumber+"', '1980-08-05', NULL,'NO_CREDENTIALS', NULL, NULL, NULL, '"+currentDate+"',NULL, NULL, NULL, NULL, NULL);");
			resultSet = statement.executeQuery("select last_insert_id() as last_id from USR_LKUP");
			resultSet.next();
			String userID=resultSet.getString("last_id");
			System.out.println("User Id="+userID);
			int userid=Integer.parseInt(userID);
			
			statement.execute("INSERT INTO `USR_ROLE_LKUP` (`USR_ID`, `MT_DT_MSTR_ID`, `CRT_TS`, `MOD_TS`, `CRT_USR_ID`, `MOD_USR_ID`) VALUES ("+userid+", 23, NULL, NULL, NULL, NULL);");
			
			statement.execute("INSERT INTO `EMPLYR_USR_MAP` (`EMPLYR_REG_DTL_ID`, `ACCESS_TOKEN`, `USR_ID`, `PSSPRT_NR`, `MYKAD_ID`, `DSGNTN_CD`,  `CRT_TS`, `MOD_TS`, `CRT_USR_ID`, `MOD_USR_ID`, `ACCESS_TKN_GNRTD_TS`) VALUES ("+empRegDetailID+", 0, "+userid+", 'PASS"+orgRegNumber+"', '"+Mykad+"', 'Director', NULL, NULL, NULL, NULL, NULL);");
			
			statement.execute("INSERT INTO `EMPLYR_BRANCH_DTL` (`BRANCH_ID`, `EMPLYR_REG_DTL_ID`, `BRANCH_TYPE`, `BRANCH_LOCATION`, `BRANCH_CNTCT_NO`, `BRANCH_FAX_NO`, `BRANCH_ADD_LN1_TX`, `BRANCH_ADD_LN2_TX`, `BRANCH_ADD_LN3_TX`, `BRANCH_ADD_LN4_TX`, `BRANCH_CITY_CD`, `BRANCH_CITY`, `BRANCH_STATE_CD`, `BRANCH_POST_CD`, `BRANCH_CNTRY_CD`, `BRANCH_STAT_CD`, `CRT_TS`, `CRT_USR_ID`, `MOD_TS`, `MOD_USR_ID`) VALUES ('1', "+empRegDetailID+", 176, 'INTEGRATION TEST SDN BHD', '01212345678', '03112233445', 'NO 55', 'JALAN SATU', 'TAMAN DUA', 'BANDAR TIGA', '1014', NULL, '010', '12345', 'MYS', 'ACTIVE', '"+currentDate+"', 'system', '"+currentDate+"', 'system');");
			
			return org_reg_number;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(),e.getCause());
		}finally{
			close();
		}
		
	}
	
	public String getAccessToken(String MYKADID) throws Exception
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			resultSet=statement.executeQuery("select ACCESS_TOKEN from EMPLYR_USR_MAP where MYKAD_id='"+MYKADID+"'");
			resultSet.next();
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(),e.getCause());
		}finally{
			close();
		}
	}
	
	public String getOTPOfEmp(String MYKADID) throws Exception
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			resultSet=statement.executeQuery("select USR_ID from  EMPLYR_USR_MAP where MYKAD_id='"+MYKADID+"'");
			resultSet.next();
			String userID= resultSet.getString(1);
			
			resultSet=statement.executeQuery("select OTP_PSSWRD_TX from USR_LKUP where USR_ID='"+userID+"'");
			resultSet.next();
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(),e.getCause());
		}finally{
			close();
		}
	}
	
	public String getOrganisationName(String orgRegNo) throws Exception
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(), DatabaseProp.getmysqlUserName(), DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			resultSet=statement.executeQuery("select ORG_NM from EMPLYR_REG_DTL where ORG_REG_NR='"+orgRegNo+"'");
			resultSet.next();
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(),e.getCause());
		}finally{
			close();
		}
	}
	
	
}
