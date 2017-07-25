package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import model.AssessmentResult;

public class ChartServlet extends HttpServlet {
	 @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	DefaultCategoryDataset ds = new DefaultCategoryDataset();

	ServletContext ctx = super.getServletContext();

//	Lesson lesson = (Lesson)ctx.getAttribute("lesson");

//	AssessmentDAO assessmentDAO = new AssessmentDAO();
//	ArrayList<Assessment> assessmentList = assessmentDAO.findByLessonId(lesson.getId());
//
//	Assessment assessment = new Assessment();
//	AssessmentResult result = assessment.aggregate(assessmentList);

	AssessmentResult result = (AssessmentResult)ctx.getAttribute("assessmentResult");

		String group0 = result.getDescription();
		ds.addValue(result.getItem1()*10, group0, "1");
		ds.addValue(result.getItem2()*10, group0, "2");
		ds.addValue(result.getItem3()*10, group0, "3");
		ds.addValue(result.getItem4()*10, group0, "4");
		ds.addValue(result.getItem5()*10, group0, "5");
		ds.addValue(result.getItem6()*10, group0, "6");
		ds.addValue(result.getItem7()*10, group0, "7");
		ds.addValue(result.getItem8()*10, group0, "8");
		ds.addValue(result.getItem9()*10, group0, "9");
		ds.addValue(result.getItem10()*10, group0, "10");
		ds.addValue(result.getItem11()*10, group0, "11");
		ds.addValue(result.getItem12()*10, group0, "12");
		ds.addValue(result.getItem13()*10, group0, "13");

		SpiderWebPlot sp = new SpiderWebPlot(ds);
		JFreeChart fc = new JFreeChart("結果レーダーチャート", TextTitle.DEFAULT_FONT, sp, true);

		    // コンテンツタイプ設定
		    response.setContentType("image/png");

		    // 円グラフ出力
		    ChartUtilities.writeChartAsPNG(response.getOutputStream(), fc, 200, 200);

		    // アウトプットストリームをフラッシュ
		    response.getOutputStream().flush();
	  }
}