<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="student.StudentDAO" %> 
<%@ page import="java.io.PrintWriter" %> <!-- 자바스크립트문을 작성하기 위해 사용 -->
<% request.setCharacterEncoding("UTF-8"); %> <!-- 모든 데이터를 UTF-8로 받음 -->
<jsp:useBean id="student" class="student.Student" scope="page" /> <!-- scope => 현재의 페이지에서만 빈즈 사용 -->
<jsp:setProperty name="student" property="studentID" />
<jsp:setProperty name="student" property="studentPassword" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판</title>
</head>
<body>
	<%
		StudentDAO studentDAO = new StudentDAO();
		int result = studentDAO.login(student.getStudentID(), student.getStudentPassword()); 
		 /* login 페이지에서 ID, Password 입력된 값으로 넘어와서 login함수에 넣어서 실행
		 -2(데이터베이스 오류), -1(아이디가 없음), 0(로그인 실패), 1(로그인 성공)이 저장*/
		 
		 if(result == 1)
		 {  //DB와 studentID,studentPassword가 일치하면 main.jsp페이지로 이동.
			 PrintWriter script = response.getWriter();
			 script.println("<script>");
			 script.println("location.href = 'main.jsp'");
			 script.println("</script>"); 
		 }
		 
		 else if(result == 0)
		 {
			 PrintWriter script = response.getWriter();
			 script.println("<script>");
			 script.println("alert('비밀번호가 틀립니다.')");
			 script.println("history.back()"); //이전 페이지로 돌려보냄(login 페이지)
			 script.println("</script>");
		 }
		 
		 else if(result == -1)
		 {
			 PrintWriter script = response.getWriter();
			 script.println("<script>");
			 script.println("alert('존재하지 않는 아이디입니다')");
			 script.println("history.back()"); //이전 페이지로 돌려보냄(login 페이지)
			 script.println("</script>");
		 }
		 
		 else if(result == -2)
		 {
			 PrintWriter script = response.getWriter();
			 script.println("<script>");
			 script.println("alert('데이터베이스 오류')");
			 script.println("history.back()"); //이전 페이지로 돌려보냄(login 페이지)
			 script.println("</script>");
		 }
	%>
</body>
</html>
