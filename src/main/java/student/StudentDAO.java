package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
	private Connection conn; 
	//DB에 접근하게 해주는 객체
	
	private PreparedStatement pstmt; 
	private ResultSet rs; 
	//정보를 담을 객체
	
	public StudentDAO()
	{
		try
		{
			   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sugang", "root", "enter");
			//DB 접속되면 conn 객체에 접속정보가 저장됨.
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// 위 코드까지가 MySQL DB에 접근할 수 있도록 설정하는 과정
    
    
	public int login(String studentID, String studentPassword) //로그인 처리하는 함수
	{
		String SQL = "SELECT password FROM student WHERE id = ?";
        //각 studentID에 해당하는 studentPassword를 조회하는 쿼리
		
        try
		{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, studentID);  //위의 SQL 쿼리 ?에 조회할 studentID적용
			rs = pstmt.executeQuery(); //쿼리의 실행 결과를 rs 객체에 저장
            
			if(rs.next()) //rs에 결과가 존재한다면
			{
				if(rs.getString(1).equals(studentPassword)) 
				  //MySQL DB의 studentPassword와 로그인 시도한 studentPassword와 일치하면
				{
					return 1; //로그인 성공
				}
				else
					return 0; //로그인 실패(비밀번호 틀림)					
			}
			return -1; //아이디가 없음  studentID=?부분 확인
            
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}

}
