package service;

import java.util.*;
import java.util.Scanner;

import dao.*;
import vo.MemberVo;

public class  MemberService implements MemberServiceImpl{
	MemberDao memberDao = new MemberDao();
	static int memberNo=1;
	@Override
	public void registMember() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MemberVo mvo = new MemberVo();
		System.out.println("===========회원등록===========");
		
		while(true) {
			System.out.print("ID : ");
			mvo.setId(sc.nextLine());
			
			int reusltId = memberDao.selectId(mvo);
			if(reusltId==1) {
				System.out.println("id가 중복됨");
				continue ;
			}
			
			System.out.print("PW : ");
			mvo.setPwd(sc.nextLine());
			System.out.print("주소 : ");
			mvo.setAddress(sc.nextLine());
			System.out.print("핸드폰번호 : ");
			mvo.setPhoneNumber(sc.nextLine());
			System.out.print("나이 : ");
			mvo.setAge(sc.nextLine());
			
			int result = memberDao.insert(mvo);
			if(result==1) {
				System.out.println("정상 입력됨");
				break;
			}else {
				System.out.println("회원등록 실패");
				break;
			} 
		}
		
	}

	@Override
	public void selectMembers() {
		// TODO Auto-generated method stub
		if(memberDao.count()==0) {
			System.out.println("회원이 존재하지 않습니다.");
			return;
		}
		System.out.println("=================전체회원정보==================");
		List<MemberVo> mlist = memberDao.selectAll();
		
		for(MemberVo mvo : mlist) {
			System.out.println(mvo.toString());
		}
		
	}

	@Override
	public void selectMember() {
//		 TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		if(memberDao.count()==0) {
			System.out.println("회원이 존재하지 않습니다.");
			return;
		}
		System.out.print("회원 번호를 선택하세요 : ");
		int memberNo = sc.nextInt();
		System.out.println("===============선택한회원정보===============");
		MemberVo vo = new MemberVo();
		vo.setNo(memberNo);
		
		if(memberDao.selectOne(vo)!=null) {
			System.out.println(memberDao.selectOne(vo));
		}else {
			System.out.println("회원정보가 없습니다...");
		}
	}

	@Override
	public void  updateMember() {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		memberDao.selectAll();
//		System.out.print("==>수정할 회원의 No를 선택하세요 : ");
//		int memberNo =  sc.nextInt();
//		MemberVo vo =  memberDao.selectOne(memberNo);
//		vo.setNo(memberNo);
//		vo.setId(vo.getId());
//		vo.setPwd(vo.getPwd());
//		sc.nextLine(); //엔터값 없애는 방법
//		System.out.print("주소 : ");
//		vo.setAddress(sc.nextLine());
//		System.out.print("핸드폰번호 : ");
//		vo.setPhoneNumber(sc.nextLine());
//		System.out.print("나이 : ");
//		vo.setAge(sc.nextLine());
//		
//		return memberDao.update(memberNo, vo);
	}

	@Override
	public void deleteMember() {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		memberDao.selectAll();
//		System.out.print("==>삭제할 회원의 No를 선택하세요 : ");
//		int memberNo =  sc.nextInt();
//		
//		return memberDao.delete(memberNo);
	}
	
}
