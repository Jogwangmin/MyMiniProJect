package myproject.profile.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myproject.profile.model.vo.Profile;

public class ProfileDAO {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "PROFILE";
	private final String PASSWORD = "PROFILE";

	public List<Profile> selectAll() {
		String query = "SELECT * FROM PROFILE_TBL";
		List<Profile> pList = null;
		Profile profile = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			pList = new ArrayList<Profile>();
			while(rset.next()) {
				profile = rsetToProfile(rset);
				pList.add(profile);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	
	private Profile rsetToProfile(ResultSet rset) throws SQLException {
		Profile profile = new Profile();
		profile.setUserId(rset.getString("USER_ID"));
		profile.setUserPw(rset.getString("USER_PW"));
		profile.setUserName(rset.getString("USER_NAME"));
		profile.setJobs(rset.getString("JOBS"));
		profile.setUserLevel(rset.getInt("USER_LEVEL"));
		profile.setUserGuild(rset.getString("USER_GUILD"));
		profile.setUserWeapon(rset.getString("USER_WEAPON"));
		return profile;
	}


	public Profile selectOneByName(String userName) {
		String query = "SELECT * FROM PROFILE_TBL WHERE USER_NAME ='"+userName+"'";
		Profile profile = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if(rset.next()) {
				profile = rsetToProfile(rset);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profile;
	}


	public Profile selectMyInfo(String userId, String userPw) {
		String query = "SELECT * FROM PROFILE_TBL WHERE USER_ID ='"+userId+"'AND USER_PW ='"+userPw+"'";
		Profile profile = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if(rset.next()) {
				profile = rsetToProfile(rset);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profile;
	}


	public int insertProfile(Profile profile) {
//		String query = "INSERT INTO PROFILE_TBL VALUES('"+profile.getUserId()+"', '"+profile.getUserPw()+"', '"+profile.getUserName()+"', '"+profile.getJobs()+"', '"+profile.getUserLevel()+"', '"+profile.getUserWeapon()+"', '"+profile.getUserGuild()+"')";
		String query = "INSERT INTO PROFILE_TBL VALUES("
				+ "'"+profile.getUserId()+"', '"+profile.getUserPw()+"', '"+profile.getUserName()+"', '"+profile.getJobs()+"', '"+profile.getUserLevel()+"', '"+profile.getUserWeapon()+"', '"+profile.getUserGuild()+"')";
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn =
					DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public int updateProfile(Profile profile) {
//		String query = "UPDATE PROFILE_TBL SET USER_NAME ='" + profile.getUserName()+"', USER_LEVEL ='" + profile.getUserLevel()+"', USER_WEAPON ='" + profile.getUserWeapon()+"', USER_GUILD ='" + profile.getUserGuild()+"'"; 
		String query = "UPDATE PROFILE_TBL SET"
				+ " USER_NAME ='" + profile.getUserName()+"',"
						+ " USER_LEVEL ='" + profile.getUserLevel()+"', "
								+ "USER_WEAPON ='" + profile.getUserWeapon()+"',"
										+ " USER_GUILD ='" + profile.getUserGuild()+"'"
											+ "WHERE USER_ID = '"+profile.getUserId()+"'"; 
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public int deleteProfile(String userId, String userPw) {
		String query = "DELETE FROM PROFILE_TBL WHERE USER_ID = '" + userId+"' AND USER_PW = '"+ userPw +"'";
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
