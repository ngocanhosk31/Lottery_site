package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.LotteryDAO;
import entity.Account;
import entity.Lottery;

/**
 * Servlet implementation class SearchAccountController
 */
@WebServlet("/SearchAccountController")
public class SearchAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String ten = request.getParameter("ten");
		String email = request.getParameter("email");
		int page = Integer.parseInt(request.getParameter("page"));
		int count = 0;
		int size = 5;
		int endPage = 0;
		List<Account> listAccount = null;
		if(ten == null && email == null) {
			response.sendRedirect("AccountController");
		}else if(ten != null && email == null) {
			try {
				count = AccountDAO.countMatchName(ten);
				listAccount = AccountDAO.getMatchName(page, ten);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}else if(ten == null && email != null) {
			try {
				count = AccountDAO.countMatchEmail(email);
				listAccount = AccountDAO.getMatchEmail(page, email);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}else if(ten != null && email != null) {
			try {
				count = AccountDAO.countMatchAccount(ten, email);
				listAccount = AccountDAO.getMatchAccount(page, ten, email);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}
		
	
		request.setAttribute("endPage", endPage);
		request.setAttribute("tenS", ten);	
		request.setAttribute("emailS", email);	
		request.setAttribute("listAccount", listAccount);
		request.getRequestDispatcher("jsp/accountManager.jsp").forward(request, response);
	}

}
