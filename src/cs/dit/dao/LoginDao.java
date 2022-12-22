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

public class LoginDao {
   
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
	   public void update(LoginDto dto) {
			String sql = "UPDATE tbl_order SET p_name = ?, quantity = ?, price = ? WHERE num = ?";
			
			try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
			{
				pstmt.setString(1,  dto.getP_name());
				pstmt.setInt(2,  dto.getQuantity());
				pstmt.setInt(3,  dto.getPrice());
				pstmt.setInt(4, dto.getNum());
				
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	   public LoginDto selectOne(int num) {
			
			//3. 전달받은 bcode를 가진 레코드를 검색하는 select 문을 아래에 작성하세요.
			String sql = "SELECT * FROM tbl_order WHERE num = ?";
			
			// 생성자 안에 getter를 사용하지 않고 입력하기 위함.
			LoginDto dto = new LoginDto();
			
			// try 안에 생성된 객체는 자동으로 해지하도록 한다.
			try (	Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					)
			{	pstmt.setInt(1, num);
			
				try(ResultSet rs = pstmt.executeQuery();)
				{
					// 사용자가 원하는 방향으로 선택시작.
					rs.next();
					
					dto.setNum(num);
					dto.setP_name(rs.getString("P_name"));
					dto.setQuantity(rs.getInt("Quantity"));
					dto.setPrice(rs.getInt("Price"));
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
	   public void delete(int num) {
			String sql = "DELETE FROM tbl_order WHERE num =?";
			
			try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
			{
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
}