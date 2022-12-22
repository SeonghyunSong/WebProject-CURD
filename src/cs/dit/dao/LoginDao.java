package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.LoginDto;
/**==============================================
 * 패키지명  cs.dit
 * 파일명 : LoginDao.java
 * 작성자 : 송성현
 * 변경이력 :
 *  2022-5-3/최초작성/송성현
 * 
 * 프로그램 설명:
 *     login 테이블과 연동하는 프로그램
 *     - insert(LoginDto)
 *     - list()
 * ============================================ */
public class LoginDao {
   
   //dbcp에서 커넥션 얻어오기
	private Connection getConnection() throws Exception{
	      
	      Context initCtx = new InitialContext();
	      
	      Context envCtx = (Context) initCtx.lookup("java:comp/env");
	      
	      DataSource ds = (DataSource) envCtx.lookup("jdbc/song1db");
	      
	      Connection con = ds.getConnection();
	      
	      return con;
	   }
	   public void insert(LoginDto dto) {
			String sql = "INSERT INTO tbl_order(p_name, quantity, price) VALUES(?, ?, ?);";
			
			try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
			{
				pstmt.setString(1,  dto.getP_name());
				pstmt.setInt(2,  dto.getQuantity());
				pstmt.setInt(3,  dto.getPrice());
				
				//1. insert 문을 실행하는 코드를 작성하세요
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   
	   public ArrayList<LoginDto> list(){
			String sql = "SELECT num, p_name, quantity, price FROM tbl_order ORDER BY num DESC;";
			ArrayList<LoginDto> dtos = new ArrayList<LoginDto>();
			
			try (	Connection con = getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
				)
				{
					while(rs.next()) {
						LoginDto dto = new LoginDto();
						
						dto.setNum(rs.getInt("num"));
						dto.setP_name(rs.getString("p_name"));
						dto.setQuantity(rs.getInt("quantity"));
						dto.setPrice(rs.getInt("price"));
						
						dtos.add(dto);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			return dtos;
		}
}