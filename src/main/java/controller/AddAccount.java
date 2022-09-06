package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import entity.MD5Library;
import entity.Validate;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
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
		request.setCharacterEncoding("UTF-8");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String matKhau = request.getParameter("matKhau");
		String vaiTro = request.getParameter("vaiTro");
		String encryptPass = null;
		try {
			if(AccountDAO.checkAccount(email)) {
				if(Validate.validatePass(matKhau)) {
					if(vaiTro.equals("User")) {	
						try {
							encryptPass = MD5Library.md5(matKhau);
							AccountDAO.addAccount(hoTen, email, encryptPass, 1);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						HttpSession session = request.getSession();
						session.setAttribute("messA", "Thêm thành công");
						response.sendRedirect("AccountController");
					}else if(vaiTro.equals("Admin")){
						try {
							encryptPass = MD5Library.md5(matKhau);
							AccountDAO.addAccount(hoTen, email, encryptPass, 0);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						HttpSession session = request.getSession();
						session.setAttribute("messA", "Thêm thành công");
						response.sendRedirect("AccountController");
					}
				}else {
				HttpSession session = request.getSession();
				session.setAttribute("errorAddA2", "Vui lòng điền mật khẩu dài hơn 6 kí tự và không chứa dấu cách");
				response.sendRedirect("AccountController");
				}
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("errorAddA1", "Email đã được đăng kí");
				response.sendRedirect("AccountController");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
