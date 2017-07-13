package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general .DefaultPieDataset;

public class ChartServlet extends HttpServlet {
	 @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

		 System.out.println("aaaaa");

	    // コンテンツタイプ設定
	    response.setContentType("image/png");

	    // 円グラフのデータ作成
	    DefaultPieDataset data = new DefaultPieDataset();
	    data.setValue("いちご", 1500);
	    data.setValue("オレンジ", 1500);
	    data.setValue("バナナ", 5000);

	    // JFreeChartオブジェクト作成
	    JFreeChart chart = new JFreeChart(new PiePlot(data));

	    // 円グラフ出力
	    ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 200, 200);

	    // アウトプットストリームをフラッシュ
	    response.getOutputStream().flush();
	  }
}