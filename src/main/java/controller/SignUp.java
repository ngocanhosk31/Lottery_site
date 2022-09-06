package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.LoginDAO;
import dao.LotteryDAO;
import entity.Account;
import entity.MD5Library;
import entity.Validate;
import gmail.SendEmail;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String mailFrom = "anhptnfx12840@funix.edu.vn";
        String password = "DZeAcrwMYh0V";
        String subject = "Thư xác nhận đăng kí tài khoản";
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        char[] randomPass = new char[length];
        for (int i = 0; i < length; i++) {
        	randomPass[i] = characters.charAt(random.nextInt(characters.length()));
        }
        String randomPassStr = new String(randomPass);
		String message = "<h2>Xin chào " + hoTen + ". Cảm ơn bạn đã đăng kí tài khoản</h2>"
				+ "<b>Đây là mật khẩu của bạn: </b>";
		message += "<span>" + randomPassStr + "</span>";
		try {
			AccountDAO.addPass(email, randomPassStr);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(AccountDAO.checkAccount(email)) {
				try {
					SendEmail.sendHtmlEmail(mailFrom, password, email, subject, message);
					request.setAttribute("hoTen", hoTen);
					request.setAttribute("email", email);
					request.getRequestDispatcher("jsp/setPassword.jsp").forward(request, response);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(!AccountDAO.checkAccount(email)) {
				request.setAttribute("errorSignup", "Email đã được đăng kí");
				request.getRequestDispatcher("jsp/signUp.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String pass = request.getParameter("matKhau");
		String newPass = request.getParameter("matKhauMoi");
		String confirmPass = request.getParameter("matKhauXacNhan");
		try {
			if(Validate.validatePass(newPass) && AccountDAO.checkPass(email, pass) 
					&& newPass.equals(confirmPass)) {
				
				String encryptPass = MD5Library.md5(newPass);
				AccountDAO.addAccount(hoTen, email, encryptPass, 1);
				Account account = LoginDAO.login(email, encryptPass);
				List<String> listCity = new ArrayList<>();
				try {
					listCity = LotteryDAO.getListCity();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				session.setAttribute("accountU", account);
				request.setAttribute("listCity", listCity);
				request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "Thông tin nhập không chính xác");
				request.getRequestDispatcher("jsp/setPassword.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
