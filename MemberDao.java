package dao;

import java.sql.*;
import java.util.*;

import vo.MemberVo;

public class MemberDao implements MemberDaoImpl{
   
   public Connection getConnection() {
      Connection conn = null;
      
      try {
         // mysql driver = com.mysql.jdbc.Driver
         // mysql url = jdbc:mysql:IP주소:포트/DB명

 		 String oracleDriver = "oracle.jdbc.driver.OracleDriver";
 		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
 		 String id="bigdata";
 		 String pwd="bigdata";
         
         Class.forName(oracleDriver);
         conn = DriverManager.getConnection(url, id, pwd);
//         System.out.println("연결이 완료되었습니다.");
         
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("DB connection error");
         
      }
      return conn;
   }
   
   @Override
   public int insert(MemberVo vo) {
      Connection conn=null;
      PreparedStatement pstmt =null;
      int result =0;
      
      try {
		conn=getConnection();
		
		String sql="Insert into member values(seq_member.NEXTVAL,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);

//		pstmt.setInt(1, vo.getNo());
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getAddress());
		pstmt.setString(4, vo.getPhoneNumber());
		pstmt.setString(5, vo.getAge());
		
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("insert error");
	} finally {
		close(conn, pstmt);
	}
      return result;
   }

   @Override
   public List<MemberVo> selectAll() {
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVo> mlist = new ArrayList<MemberVo>();
		
		try {
			conn=getConnection();
			
			String sql="Select * from member";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo mvo = new MemberVo();
				mvo.setNo(rs.getInt("no"));
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhoneNumber(rs.getString("phoneNumber"));
				mvo.setAge(rs.getString("age"));
				
				mlist.add(mvo);
			}
			
		} catch (Exception e) {
		} finally {
			close(conn,rs,pstmt);
		}
		return mlist;
	}

   @Override
   public MemberVo selectOne(MemberVo vo) {
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo mvo = null;
		
		try {
			conn=getConnection();
			String sql="select * from member where no= ?"  ;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
//			pstmt.setString(2, vo.getId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mvo=new MemberVo();
				
				mvo.setNo(rs.getInt("no"));
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhoneNumber(rs.getString("phoneNumber"));
				mvo.setAge(rs.getString("age"));
				
			}
		} catch (Exception e) {
		} finally {
				close(conn,rs,pstmt);
		}
	    return mvo;
   }
   
   public int selectId(MemberVo vo) {
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo mvo = null;
		int result=0;
		
		try {
			conn=getConnection();
			String sql="select count(*) from member where id= ?"  ;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
		} finally {
				close(conn,rs,pstmt);
		}
	    return result;
  }

   @Override
   public int update(MemberVo vo) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int delete(MemberVo vo) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int count() {
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result=0;
		
		MemberVo mvo = null;
		
		try {
			conn=getConnection();
			String sql="select count(*) from member"  ;
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				rs.getInt("count(*)");
				result = rs.getInt(1);
			}
		} catch (Exception e) {
		} finally {
				close(conn,rs,pstmt);
		}
		
      return result;
   }
   
   
   
   public void close(Connection conn, ResultSet rs, PreparedStatement pstmt) {
	   try {
		   if(pstmt!=null) pstmt.close();
		   if(rs!=null) rs.close();
		   if(conn!=null) conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
   }
   
   public void close(Connection conn, PreparedStatement pstmt) {
	   try {
		   if(pstmt!=null) pstmt.close();
		   if(conn!=null) conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
   }

}

   
