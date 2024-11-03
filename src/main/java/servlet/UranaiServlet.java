package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UranaiServlet")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 運勢をランダムで決定
		String[] luckArray = { "極上", "吉", "並", "最悪" };
		// Math.random()は0~1未満の値を返すので、この条件だと3以上には成り得ない(つまり「最悪」は決して出ない)
		int index = (int)(Math.random() * 3);
		System.out.println(index);
		String todaysLuck = luckArray[index];
		// 実行日を取得
		Date date = new Date(); // importはjava.sql.Dateではない点に注意
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);
		
		// HTMLを出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html");
		out.println("<html><head><meta charset=\"UTF-8\" />");
		out.println("<title>スッキリ占い</title></head>");
		out.println("<body>");
		out.println("<p>" + today +"の運勢は「" + todaysLuck + "」です</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
