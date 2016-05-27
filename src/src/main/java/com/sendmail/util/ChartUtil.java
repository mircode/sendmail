package com.sendmail.util;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author 周小鱼(zxy)
 * 折线图/柱状图/饼状图
 */
public  class ChartUtil {

	/**
	 * 饼状图
	 * @param data 数据
	 * @param datadescription 数据描述
	 * @param chartTitle 图标题
	 * @param charName 生成图的名字
	 * @param pieKeys 分饼的名字集
	 * @return
	 */
	public static JFreeChart createValidityComparePimChar(double[] data,String[] datadescription,String chartTitle, String charName, String[] pieKeys){
		PieDataset dataset = getDataPieSetByUtil(data,datadescription);//获取数据集
		return getValidityComparePimChar(dataset, chartTitle, charName, pieKeys);

	}
	/**
	 * 饼状图
	 * @param dataset 数据集
	 * @param chartTitle 图标题
	 * @param charName 生成图的名字
	 * @param pieKeys 分饼的名字集
	 * @return
	 */
	public static JFreeChart getValidityComparePimChar(PieDataset dataset,String chartTitle, String charName, String[] pieKeys){
		JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, // chart
		        // title
		        dataset,// data
		        true,// include legend
		        true, 
		        false
		        );
		// 使下说明标签字体清晰,去锯齿类似于
		// chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);的效果
		chart.setTextAntiAlias(false);
		// 图片背景色
		chart.setBackgroundPaint(Color.white);
		// 设置图标题的字体重新设置title
		Font font = new Font("隶书", Font.BOLD, 25);
		TextTitle title = new TextTitle(chartTitle);
		title.setFont(font);
		chart.setTitle(title);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		// 图片中显示百分比:默认方式

		// 指定饼图轮廓线的颜色
		// plot.setBaseSectionOutlinePaint(Color.BLACK);
		// plot.setBaseSectionPaint(Color.BLACK);

		// 设置无数据时的信息
		plot.setNoDataMessage("无对应的数据，请重新查询。");

		// 设置无数据时的信息显示颜色
		plot.setNoDataMessagePaint(Color.red);

		// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
		        "{0}={1}({2})", NumberFormat.getNumberInstance(),
		        new DecimalFormat("0.00%")));
		// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
		        "{0}={1}({2})"));

		plot.setLabelFont(new Font("SansSerif", Font.TRUETYPE_FONT, 12));

		// 指定图片的透明度(0.0-1.0)
		plot.setForegroundAlpha(0.65f);
		// 指定显示的饼图上圆形(false)还椭圆形(true)
		plot.setCircular(false, true);

		// 设置第一个 饼块section 的开始位置，默认是12点钟方向
		plot.setStartAngle(90);

		// // 设置分饼颜色
		plot.setSectionPaint(pieKeys[0], new Color(244, 194, 144));
		plot.setSectionPaint(pieKeys[1], new Color(144, 233, 144));
		/*------这句代码解决了底部汉字乱码的问题-----------*/   
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); 
		return chart;
	}
	
	/**
	 * 柱状图
	 * @param data 数据
	 * @param rowKeys 行
	 * @param columnKeys 列
	 * @param xName x轴的说明（如种类，时间等）
	 * @param yName y轴的说明（如速度，时间等）
	 * @param chartTitle 图标题
	 * @param charName 生成图片的名字
	 * @return
	 */
	public static JFreeChart createBarChart(double[][] data, String[] rowKeys,String[] columnKeys, String xName,
	        String yName, String chartTitle, String charName){
		CategoryDataset dataset = getBarData(data,rowKeys,columnKeys);
		return getBarChart(dataset, xName, yName, chartTitle, charName);
	}	
	/**
	 * 柱状图
	 * @param dataset 数据集
	 * @param xName x轴的说明（如种类，时间等）
	 * @param yName y轴的说明（如速度，时间等）
	 * @param chartTitle 图标题
	 * @param charName 生成图片的名字
	 * @return
	 */
	public static JFreeChart getBarChart(CategoryDataset dataset, String xName,
	        String yName, String chartTitle, String charName){
		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle, // 图表标题
				xName, // 目录轴的显示标签
				yName, // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		chart.setTextAntiAlias(false);
		chart.setBackgroundPaint(Color.WHITE);
		// 设置图标题的字体重新设置title
		Font font = new Font("隶书", Font.BOLD, 25);
		TextTitle title = new TextTitle("历年成绩 比较");
		title.setFont(font);
		chart.setTitle(title);
		
		// 设置面板字体
		Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);

		chart.setBackgroundPaint(Color.WHITE);

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		// x轴 // 分类轴网格是否可见
		categoryplot.setDomainGridlinesVisible(true);
		// y轴 //数据轴网格是否可见
		categoryplot.setRangeGridlinesVisible(true);

		categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩

		categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩

		categoryplot.setBackgroundPaint(Color.lightGray);

		// 设置轴和面板之间的距离
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		/*------设置X轴坐标上的文字-----------*/ 
		domainAxis.setLabelFont(labelFont);// 轴标题
		 /*------设置X轴的标题文字------------*/ 
		domainAxis.setTickLabelFont(labelFont);// 轴数值
		//X轴值的倾斜度 (45,90,STANDARD)分up/down
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // 横轴上的
		// Lable
		// 45度倾斜
		// 设置距离图片左端距离
		domainAxis.setLowerMargin(0.0);
		// 设置距离图片右端距离
		domainAxis.setUpperMargin(0.0);

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		/*------设置Y轴坐标上的文字-----------*/ 
	    numberaxis.setTickLabelFont(labelFont);// 轴标题   
	    /*------设置Y轴的标题文字------------*/ 
		numberaxis.setLabelFont(labelFont);// 轴数值
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);
		
		/*------这句代码解决了底部汉字乱码的问题-----------*/   
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
		return chart;
	}
	
	/**
	 * 折线图
	 * @param chartTitle
	 * @param x x轴的说明（如种类，时间等）
	 * @param y y轴的说明（如速度，时间等）
	 * @param data 
	 * @param rowKeys
	 * @param columnKeys
	 * @param charName
	 * @return
	 */
	public static JFreeChart createTimeXYChar(String chartTitle, String x, String y,
			double[][] data, String[] rowKeys,String[] columnKeys, String charName){
		CategoryDataset dataset = getBarData(data,rowKeys,columnKeys);
		 return getTimeXYChar(chartTitle, x, y, dataset, charName);
	 }
	/**
	 * 折线图
	 * @param chartTitle
	 * @param x x轴的说明（如种类，时间等）
	 * @param y y轴的说明（如速度，时间等）
	 * @param dataset数据集
	 * @param charName 生成图片的名字
	 * @return
	 */
	public static JFreeChart getTimeXYChar(String chartTitle, String x, String y,
			CategoryDataset dataset, String charName){
		JFreeChart chart = ChartFactory.createLineChart(
				chartTitle,// 图表标题
				x,// 目录轴的显示标签
				y,// 数值轴的显示标签
				dataset,// 数据集
				PlotOrientation.VERTICAL,// 图表方向：水平、垂直
				true,// 是否显示图例(对于简单的柱状图必须是false)
				true, // 是否生成工具
				false // 是否生成URL链接
				);

		chart.setTextAntiAlias(false);
		chart.setBackgroundPaint(Color.WHITE);
		// 设置图标题的字体重新设置title
		Font font = new Font("隶书", Font.BOLD, 25);
		TextTitle title = new TextTitle(chartTitle);
		title.setFont(font);
		chart.setTitle(title);
		// 设置面板字体
		Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);

		chart.setBackgroundPaint(Color.WHITE);

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		// x轴 // 分类轴网格是否可见
		categoryplot.setDomainGridlinesVisible(true);
		// y轴 //数据轴网格是否可见
		categoryplot.setRangeGridlinesVisible(true);

		categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩

		categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩

		categoryplot.setBackgroundPaint(Color.lightGray);

		// 设置轴和面板之间的距离
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		/*------设置X轴坐标上的文字-----------*/ 
		domainAxis.setLabelFont(labelFont);// 轴标题
		 /*------设置X轴的标题文字------------*/ 
		domainAxis.setTickLabelFont(labelFont);// 轴数值

		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的
		// Lable
		// 45度倾斜
		// 设置距离图片左端距离
		domainAxis.setLowerMargin(0.0);
		// 设置距离图片右端距离
		domainAxis.setUpperMargin(0.0);

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		/*------设置Y轴坐标上的文字-----------*/ 
	    numberaxis.setTickLabelFont(labelFont);// 轴标题   
	    /*------设置Y轴的标题文字------------*/ 
		numberaxis.setLabelFont(labelFont);// 轴数值
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);
		
		/*------这句代码解决了底部汉字乱码的问题-----------*/   
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));   

		// 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
		        .getRenderer();

		lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
		lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见

		// 显示折点数据
		 lineandshaperenderer.setBaseItemLabelGenerator(new
		 StandardCategoryItemLabelGenerator());
		 lineandshaperenderer.setBaseItemLabelsVisible(true);
		 return chart;
	}
	
	// 柱状图,折线图 数据集
	public static CategoryDataset getBarData(double[][] data, String[] rowKeys,String[] columnKeys){
		return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);

	}
	// 饼状图 数据集
	public static PieDataset getDataPieSetByUtil(double[] data,String[] datadescription){
		if (data != null && datadescription != null){
			if (data.length == datadescription.length){
				DefaultPieDataset dataset = new DefaultPieDataset();
				for (int i = 0; i < data.length; i++){
					dataset.setValue(datadescription[i], data[i]);
				}
				return dataset;
			}
		}
		return null;
	}
}
