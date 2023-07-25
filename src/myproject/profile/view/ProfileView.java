package myproject.profile.view;

import java.util.List;
import java.util.Scanner;

import myproject.profile.controller.ProfileController;
import myproject.profile.model.vo.Profile;

public class ProfileView {
private ProfileController controller;
	
	public ProfileView() {
		controller = new ProfileController();
	}
	
	public void startProgram() {
		Profile profile = null;
		List<Profile> pList = null;
		String userName = null;
		String userId = null; 
		String userPw = null; 
		finish :
		while(true) {
			int choice = printMenu();
			switch(choice) {
			case 1 : 
				pList = controller.printProfileList();
				if(!pList.isEmpty()) {
					showAllProfiles(pList);
				}else {
					displayError("캐릭터 정보가 없습니다");
				}
				break;
			case 2 : 
				pList = controller.printProfileList();
				if(!pList.isEmpty()) {
					showProfilesAllInfo(pList);
				}else {
					displayError("캐릭터 정보가 없습니다");
				}
				break;
			case 3 :
				userName = inputUserName();
				profile = controller.printProfileByName(userName);
				if(profile != null) {
					showUser(profile);
				}else {
					displayError("캐릭터 정보가 없습니다");
				}
				break;
			case 4 :
				userId = inputUserId();
				userPw = inputUserPw();
				profile = controller.printMyProfile(userId, userPw);
				if(profile != null) {
					showMyInfo(profile);
				}else {
					displayError("아이디 또는 비밀번호를 확인해주세요");
				}
				break;
			case 5 :
				profile = inputProfile();
				int result = controller.insertProfile(profile);
				if(result > 0) {
					displaySuccess("캐릭터 정보 등록 완료");
				}else {
					displayError("캐릭터 정보 등록 실패");
				}
				break;
			case 6 :
				profile = modifyProfile();
				result = controller.modifyProfile(profile);
				if(result > 0) {
					displaySuccess("캐릭터 정보 변경 완료");
				}else {
					displayError("캐릭터 정보 변경 실패");
				}
				break;
			case 7 :
				userId = inputUserId();
				userPw = inputUserPw();
				result = controller.deleteProfile(userId, userPw);
				if(result > 0) {
					displaySuccess("캐릭터 정보 삭제 완료");
				}else {
					displayError("캐릭저 정보 삭제 실패");			
				}
				break;
			case 0 :
				exitProgram();
				break finish;
			}
		}
	}
	
	private void exitProgram() {
		System.out.println("프로그램을 종료합니다.");
	}

	private Profile modifyProfile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 유저 정보 수정 =====");
		System.out.print("아이디 : ");
		String userId = sc.next();
		System.out.print("닉네임 : ");
		String userName = sc.next();
		System.out.print("레벨 : ");
		int userLevel = sc.nextInt();
		System.out.print("무기 : ");
		String userWeapon = sc.next();
		System.out.print("길드 : ");
		String userGuild = sc.next();
		Profile profile = new Profile(userId ,userName, userLevel, userWeapon, userGuild);
		return profile;
	}

	private void displaySuccess(String message) {
		System.out.println("성공! " + message);
	}

	private void showMyInfo(Profile profile) {
		System.out.println("===== 유저 정보 조회 결과 =======");
		System.out.printf("아이디 : %s, 비밀번호 : %s, 닉네임 : %s, 직업 : %s, 레벨 : %d레벨, 무기 : %s, 길드 : %s\n"
				, profile.getUserId()
				, profile.getUserPw()
				, profile.getUserName()
				, profile.getJobs()
				, profile.getUserLevel()
				, profile.getUserWeapon()
				, profile.getUserGuild());
	}


	private Profile inputProfile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 유저 정보 등록 =====");
		System.out.print("아이디 : ");
		String userId = sc.next();
		System.out.print("비밀번호 : ");
		String userPw = sc.next();
		System.out.print("닉네임 : ");
		String userName = sc.next();
		System.out.print("직업 : ");
		String jobs = sc.next();
		System.out.print("레벨 : ");
		int userLevel = sc.nextInt();
		System.out.print("무기 : ");
		String userWeapon = sc.next();
		System.out.print("길드 : ");
		String userGuild = sc.next();
		Profile profile = new Profile(userId, userPw, userName, jobs, userLevel, userWeapon, userGuild);
		return profile;
	}

	private String inputUserPw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		return userpw;
	}

	private String inputUserId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 내 캐릭터 정보 조회 =======");
		System.out.print("아이디  : ");
		String userId = sc.next();
		return userId;
	}

	private void showUser(Profile profile) {
		System.out.println("===== 유저 정보 조회 결과 =======");
		System.out.printf("닉네임 : %s, 직업 : %s, 레벨 : %d레벨, 무기 : %s, 길드 : %s\n"
				, profile.getUserName()
				, profile.getJobs()
				, profile.getUserLevel()
				, profile.getUserWeapon()
				, profile.getUserGuild());
	}

	private String inputUserName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 유저 정보 조회 =======");
		System.out.print("검색할 유저 : ");
		String userName = sc.next();
		return userName;
	}

	private void showAllProfiles(List<Profile> pList) {
		System.out.println("===== 유저 정보 =======");
		for(Profile profile : pList) {
			System.out.printf("닉네임 : %s, 직업 : %s, 레벨 : %d레벨, 무기 : %s, 길드 : %s\n"
					, profile.getUserName()
					, profile.getJobs()
					, profile.getUserLevel()
					, profile.getUserWeapon()
					, profile.getUserGuild());
		}
	}
	private void showProfilesAllInfo(List<Profile> pList) {
		System.out.println("===== 유저 정보 =======");
		for(Profile profile : pList) {
			System.out.printf("아이디 : %s, 비밀번호 : %s, 닉네임 : %s, 직업 : %s, 레벨 : %d레벨, 무기 : %s, 길드 : %s\n"
					, profile.getUserId()
					, profile.getUserPw()
					, profile.getUserName()
					, profile.getJobs()
					, profile.getUserLevel()
					, profile.getUserWeapon()
					, profile.getUserGuild());
		}
	}
	private void displayError(String message) {
		System.out.println("검색실패! " + message);
	}

	private int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 유저 정보 검색 프로그램 ======");
		System.out.println("1. 유저 전체 조회");
		System.out.println("2. 유저 전체 조회(관리자)");
		System.out.println("3. 유저 조회");
		System.out.println("4. 내 캐릭터 정보 조회");
		System.out.println("5. 캐릭터 정보 등록");
		System.out.println("6. 캐릭터 정보 수정");
		System.out.println("7. 캐릭터 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("원하는 서비스 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
}
