package myproject.profile.model.vo;

public class Profile {
	private String userId;
	private String userPw;
	private String userName;
	private String jobs;
	private int userLevel;
	private String userWeapon;
	private String userGuild;

	public Profile() {}

	public Profile(String userId, String userName, int userLevel, String userWeapon, String userGuild) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userLevel = userLevel;
		this.userWeapon = userWeapon;
		this.userGuild = userGuild;
	}

	public Profile(String userId, String userPw, String userName, String jobs, int userLevel, String userWeapon,
			String userGuild) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.jobs = jobs;
		this.userLevel = userLevel;
		this.userWeapon = userWeapon;
		this.userGuild = userGuild;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserGuild() {
		return userGuild;
	}

	public void setUserGuild(String userGuild) {
		this.userGuild = userGuild;
	}

	public String getUserWeapon() {
		return userWeapon;
	}

	public void setUserWeapon(String userWeapon) {
		this.userWeapon = userWeapon;
	}

	@Override
	public String toString() {
		return "프로필 [아이디=" + userId + ", 비밀번호=" + userPw + ", 닉네임=" + userName + ", 직업=" + jobs
				+ ", 레벨=" + userLevel + ", 길드=" + userGuild + ", 무기=" + userWeapon + "]";
	}
}
