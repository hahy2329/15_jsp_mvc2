package boardBasic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardBasic.dao.BoardDAO;
import boardBasic.dto.BoardDTO;

/**
 * Servlet implementation class DetailBoard
 */
@WebServlet("/bDetail")
public class DetailBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Long.parseLong(request.getParameter("boardId"));
		
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardDetail(Long.parseLong(request.getParameter("boardId")),true);
		
		// 단위 테스트 : System.out.println(boardDTO);
		
		request.setAttribute("boardDTO", boardDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_boardBasicEx/bDetail.jsp");
		dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
