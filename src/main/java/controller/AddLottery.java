package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LotteryDAO;
import entity.Validate;

/**
 * Servlet implementation class AddLottery
 */
@WebServlet("/AddLottery")
public class AddLottery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLottery() {
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
		
		String thoiGian = request.getParameter("thoiGian");
		String tinh = request.getParameter("tinh");
		String giaiDacBiet = request.getParameter("giaiDacBiet");
		String giaiNhat = request.getParameter("giaiNhat");
		String giaiNhi = request.getParameter("giaiNhi");
		String giaiBa = request.getParameter("giaiBa");
		String giaiTu = request.getParameter("giaiTu");
		String giaiNam = request.getParameter("giaiNam");
		String giaiSau = request.getParameter("giaiSau");
		String giaiBay = request.getParameter("giaiBay");
		String giaiTam = request.getParameter("giaiTam");
		
		if(!Validate.validateNumber(giaiDacBiet)
				|| !Validate.validateNumber(giaiNhat) || !Validate.validateNumber(giaiNhi)
				|| !Validate.validateNumber(giaiBa) || !Validate.validateNumber(giaiTu)
				|| !Validate.validateNumber(giaiNam) || !Validate.validateNumber(giaiSau)
				|| !Validate.validateNumber(giaiBay) || !Validate.validateNumber(giaiTam)) {
			HttpSession session = request.getSession();
			session.setAttribute("errorAddL", "Vui l??ng nh???p m?? s??? v?? l?? d???ng s??? c??ch nhau b???i d???u ph???y");
			response.sendRedirect("LotteryController");
		}else {
			try {
				if(!LotteryDAO.checkLottery(tinh, thoiGian)) {
					HttpSession session = request.getSession();
					session.setAttribute("errorAddL", "Th??ng tin v?? s??? ????i " + tinh + " (" + thoiGian + ") " + " ???? t???n t???i");
					response.sendRedirect("LotteryController");
				}else {
					
					LotteryDAO.addLottery(tinh, thoiGian, giaiDacBiet, giaiNhat, giaiNhi, giaiBa,
							giaiTu, giaiNam, giaiSau, giaiBay, giaiTam);
					HttpSession session = request.getSession();
					session.setAttribute("messageL", "Th??m th??nh c??ng");
					response.sendRedirect("LotteryController");
				}
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
