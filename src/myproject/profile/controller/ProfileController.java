package myproject.profile.controller;

import java.util.List;

import myproject.profile.model.dao.ProfileDAO;
import myproject.profile.model.vo.Profile;

public class ProfileController {
	
	private ProfileDAO pDao;

	public ProfileController() {
		pDao = new ProfileDAO();
	}

	public List<Profile> printProfileList() {
		List<Profile> pList = pDao.selectAll();
		return pList;
	}

	public Profile printProfileByName(String userName) {
		Profile profile = pDao.selectOneByName(userName);
		return profile;
	}

	public Profile printMyProfile(String userId, String userPw) {
		Profile profile = pDao.selectMyInfo(userId, userPw);
		return profile;
	}

	public int insertProfile(Profile profile) {
		int result = pDao.insertProfile(profile);
		return result;
	}

	public int modifyProfile(Profile profile) {
		int result = pDao.updateProfile(profile);
		return result;
	}

	public int deleteProfile(String userId, String userPw) {
		int result = pDao.deleteProfile(userId, userPw);
		return result;
	}
}
