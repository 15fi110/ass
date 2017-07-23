package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartServlet extends HttpServlet {
	 @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

//	    // コンテンツタイプ設定
//	    response.setContentType("image/png");
//
//	    // 円グラフのデータ作成
//	    DefaultPieDataset data = new DefaultPieDataset();
//	    data.setValue("いちご", 1500);
//	    data.setValue("オレンジ", 1500);
//	    data.setValue("バナナ", 5000);
//
//	    // JFreeChartオブジェクト作成
//	    JFreeChart chart = new JFreeChart(new PiePlot(data));
//
//	    // 円グラフ出力
//	    ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 200, 200);
//
//	    // アウトプットストリームをフラッシュ
//	    response.getOutputStream().flush();


	DefaultCategoryDataset ds = new DefaultCategoryDataset();

		Random rand = new Random();

		String group0 = "上野さん";
		ds.addValue(rand.nextDouble()*10, group0, "容姿");
		ds.addValue(rand.nextDouble()*10, group0, "学歴");
		ds.addValue(rand.nextDouble()*10, group0, "知力");
		ds.addValue(rand.nextDouble()*10, group0, "財力");
		ds.addValue(rand.nextDouble()*10, group0, "変態");
		ds.addValue(rand.nextDouble()*10, group0, "紳士");

		SpiderWebPlot sp = new SpiderWebPlot(ds);
		JFreeChart fc = new JFreeChart("人間力レーダーチャート", TextTitle.DEFAULT_FONT, sp, true);

		    // コンテンツタイプ設定
		    response.setContentType("image/png");

		    // 円グラフ出力
		    ChartUtilities.writeChartAsPNG(response.getOutputStream(), fc, 200, 200);

		    // アウトプットストリームをフラッシュ
		    response.getOutputStream().flush();
	  }
}