package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import entity.MD5Library;
import entity.Validate;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String maXacNhan1 = request.getParameter("maXacNhan1");
		String maXacNhan2 = request.getParameter("maXacNhan2");
		String email = request.getParameter("email");
		String newPass = request.getParameter("matKhauMoi");
		String confirmPass = request.getParameter("matKhauXacNhan");
		if(Validate.validatePass(newPass) && newPass.equals(confirmPass) 
				&& maXacNhan1.equals(maXacNhan2)) {
			try {
				AccountDAO.changePass(newPass, email);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("email", email);
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Mã xác nhận không đúng hoặc mật khẩu không hợp lệ");
			request.getRequestDispatcher("jsp/setForgotPass.jsp").forward(request, response);
		}
	}

}
