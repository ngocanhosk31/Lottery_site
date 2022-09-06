package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import gmail.SendEmail;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		try {
			if(AccountDAO.checkAccount(email)) {
				request.setAttribute("errorEmail", "Email chưa được đăng kí");
				request.getRequestDispatcher("jsp/forgotPassword.jsp").forward(request, response);
			}else if(!AccountDAO.checkAccount(email)){
				int length = 6;
		        String characters = "0123456789";
		        Random random = new Random();
		        char[] randomCode = new char[length];
		        for (int i = 0; i < length; i++) {
		        	randomCode[i] = characters.charAt(random.nextInt(characters.length()));
		        }
		        String randomCodeStr = new String(randomCode);
				String mailFrom = "anhptnfx12840@funix.edu.vn";
		        String passwordMail = "DZeAcrwMYh0V";
		        String subject = "Thư xác nhận lấy lại mật khẩu";
		        String message = "<h3>Đây là mã xác nhận đặt lại mật khẩu của bạn: " + randomCodeStr + "</h3>";
				
				try {
					SendEmail.sendHtmlEmail(mailFrom, passwordMail, email, subject, message);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("email", email);
				request.setAttribute("maXacNhan", randomCodeStr);
				request.getRequestDispatcher("jsp/setForgotPass.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
