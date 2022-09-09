package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dao.LotteryDAO;
import entity.Account;
import entity.MD5Library;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//lấy tt trên cookie
		//truyền vào form login
		Cookie[] arr = request.getCookies();
		if(arr != null) {
			for(Cookie o : arr) {
				if(o.getName().equals("email")) {
					request.setAttribute("email", o.getValue());
				}
				if(o.getName().equals("password")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		String encryptPass = MD5Library.md5(password);
		try {
			Account account = LoginDAO.login(email, encryptPass);
			if(account == null) {
				request.setAttribute("errorLogin", "Email hoặc mật khẩu của bạn không đúng");
				request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
			}else {
				if(account.isUser() == true) {
					Cookie userCookie = new Cookie("email", email);
					Cookie passCookie = new Cookie("password", password);
					if(remember != null) {
						userCookie.setMaxAge(60*60*24);
						passCookie.setMaxAge(60*60*24);
					}else {
						userCookie.setMaxAge(0);
						passCookie.setMaxAge(0);
					}
					response.addCookie(userCookie);
					response.addCookie(passCookie);
					List<String> listCity = null;
					try {
						listCity = LotteryDAO.getListCity();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					HttpSession session = request.getSession();
					session.setAttribute("accountU", account);
					session.setAttribute("listCity", listCity);
					session.setMaxInactiveInterval(60*60*24);
					response.sendRedirect("jsp/home.jsp");
				}else if(account.isAdmin() == true) {
					Cookie userCookie = new Cookie("email", email);
					Cookie passCookie = new Cookie("password", password);
					if(remember != null) {
						userCookie.setMaxAge(60*60*24);
						passCookie.setMaxAge(60*60*24);
					}else {
						userCookie.setMaxAge(0);
						passCookie.setMaxAge(0);
					}
					response.addCookie(userCookie);
					response.addCookie(passCookie);
					
					HttpSession session = request.getSession();
					session.setAttribute("accountA", account);
					session.setMaxInactiveInterval(60*60*24);
					response.sendRedirect("LotteryController");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
