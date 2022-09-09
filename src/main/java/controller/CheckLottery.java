package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LotteryCheckDAO;
import dao.LotteryDAO;
import entity.Account;
import entity.Award;

/**
 * Servlet implementation class CheckLottery
 */
@WebServlet("/CheckLottery")
public class CheckLottery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLottery() {
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
		request.setCharacterEncoding("UTF-8");
		String tinh = request.getParameter("tinh");
		String thoiGian = request.getParameter("thoiGian");
		String maSo = request.getParameter("maSo");
		List<String> listCity = new ArrayList<>();
		HttpSession session = request.getSession();
		try {
			Account acc = (Account)session.getAttribute("accountU");
			String hoTen = null;
			String email = null;
			if(acc != null) {
				
				hoTen = acc.getHoTen();
				email = acc.getEmail();
			}
			
			Award award = LotteryCheckDAO.checkLottery(tinh, thoiGian);
			if(award != null) {
				if(Arrays.asList(award.getGiaiDacBiet()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải đặc biệt vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải đặc biệt");
					}
				}else if(Arrays.asList(award.getGiaiNhat()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải nhất vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải nhất");
					}
				}else if(Arrays.asList(award.getGiaiNhi()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải nhì vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải nhì");
					}
				}else if(Arrays.asList(award.getGiaiBa()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải ba vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải ba");
					}
				}else if(Arrays.asList(award.getGiaiTu()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải tư vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải tư");
					}
				}else if(Arrays.asList(award.getGiaiNam()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải năm vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải năm");
					}
				}else if(Arrays.asList(award.getGiaiSau()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải sáu vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải sáu");
					}
				}else if(Arrays.asList(award.getGiaiBay()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải bảy vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải bảy");
					}
				}else if(Arrays.asList(award.getGiaiTam()).contains(maSo)) {
					session.setAttribute("result", "Chúc mừng bạn đã trúng giải tám vé số đài "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "giải tám");
					}
				}else {
					session.setAttribute("result", "Vé số của bạn không trúng thưởng. Chúc bạn may mắn lần sau!");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "không trúng");
					}
				}
			}else {
				session.setAttribute("result", "Xin lỗi, dữ liệu vé số đài "+tinh+"("+thoiGian+")"+" chưa được cập nhật.");
			}
			
	  		try {
	  			listCity = LotteryDAO.getListCity();
	  		} catch (ClassNotFoundException | SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("listCity", listCity);
		response.sendRedirect("jsp/home.jsp");
	}

}
