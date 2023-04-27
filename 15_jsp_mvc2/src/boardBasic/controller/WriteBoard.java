package boardBasic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardBasic.dao.BoardDAO;
import boardBasic.dto.BoardDTO;


@WebServlet("/bWrite")
public class WriteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step1_boardBasicEx/bWrite.jsp");
		dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파라메타 받음 
		
		request.setCharacterEncoding("utf-8");
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setWriter(request.getParameter("writer"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setPassword(request.getParameter("password"));
		boardDTO.setContent(request.getParameter("content"));
		
		
		
		//2. DB에 집어넣음 
		BoardDAO.getInstance().insertBoard(boardDTO);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String jsScript ="<script>";
				jsScript +="alert('등록 되었습니다');";
				jsScript +="location.href='bList';";
				jsScript +="</script>";
		
		out.print(jsScript);
		
		
		
		//3. 넣었다고 유저에게 알려주기
		
		
	}

}
