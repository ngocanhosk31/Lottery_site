package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.LotteryDAO;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		AccountDAO.deleteAccount(id);
		request.getRequestDispatcher("AccountController").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String[] arrayId = request.getParameterValues("idAccount");
		if(request.getParameter("idAccount") == null) {
			HttpSession session = request.getSession();
			session.setAttribute("errorDeleteA", "Vui lòng chọn các bản ghi trước khi xoá");
			response.sendRedirect("AccountController");
		}else {
			for(int i = 0; i < arrayId.length; i++) {
				AccountDAO.deleteAccount(arrayId[i]);
			}
			HttpSession session = request.getSession();
			session.setAttribute("messageA", "Xoá thành công");
			response.sendRedirect("AccountController");
		}
	}

}