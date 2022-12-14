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
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i ?????c bi???t v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i ?????c bi???t");
					}
				}else if(Arrays.asList(award.getGiaiNhat()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i nh???t v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i nh???t");
					}
				}else if(Arrays.asList(award.getGiaiNhi()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i nh?? v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i nh??");
					}
				}else if(Arrays.asList(award.getGiaiBa()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i ba v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i ba");
					}
				}else if(Arrays.asList(award.getGiaiTu()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i t?? v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i t??");
					}
				}else if(Arrays.asList(award.getGiaiNam()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i n??m v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i n??m");
					}
				}else if(Arrays.asList(award.getGiaiSau()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i s??u v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i s??u");
					}
				}else if(Arrays.asList(award.getGiaiBay()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i b???y v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i b???y");
					}
				}else if(Arrays.asList(award.getGiaiTam()).contains(maSo)) {
					session.setAttribute("result", "Ch??c m???ng b???n ???? tr??ng gi???i t??m v?? s??? ????i "+tinh+"("+thoiGian+")");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "gi???i t??m");
					}
				}else {
					session.setAttribute("result", "V?? s??? c???a b???n kh??ng tr??ng th?????ng. Ch??c b???n may m???n l???n sau!");
					if(acc != null) {
						LotteryCheckDAO.addHistory(tinh, thoiGian, hoTen, email, maSo, "kh??ng tr??ng");
					}
				}
			}else {
				session.setAttribute("result", "Xin l???i, d??? li???u v?? s??? ????i "+tinh+"("+thoiGian+")"+" ch??a ???????c c???p nh???t.");
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
