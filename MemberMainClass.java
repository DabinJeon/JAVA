
package main;

import java.util.Scanner;

import service.*;
import vo.MemberVo;

public class MemberMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MemberServiceImpl msi = new MemberService();
		
		while(true) {
			System.out.println("====회원관리 프로그2램====");
			System.out.println("메뉴 : 1.회원정보(전체)");
			System.out.println("         2.회원정보");
			System.out.println("         3.회원등록");
			System.out.println("         4.회원정보수정");
			System.out.println("         5.회원삭제");
			System.out.println("         0.종료");
			System.out.println("=====================");
			System.out.print("입력 : ");
			int menuSelect = sc.nextInt();
			if(menuSelect == 1) {
				msi.selectMembers();
			}else if(menuSelect ==2) {
				msi.selectMember();
			}else if(menuSelect==3) {
				msi.registMember();

			}else if(menuSelect==4) {
				msi.updateMember();

			}else if(menuSelect==5) {
				 msi.deleteMember();

			}else if(menuSelect==0){
				break;
			}else {
				System.out.println("잘못입력 하셨습니다. 다시 입력하세요~");
			}
			try {
				Thread.sleep(1000);
				System.out.println("\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
		
	}

}
