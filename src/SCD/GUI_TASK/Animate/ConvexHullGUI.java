//package SCD.GUI_TASK.Animate;
//
//import org.jfree.*;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//
//public class LineChartExample {
//    public static void main(String[] args) {
//        XYSeries series = new XYSeries("Data");
//        series.add(1, 1);
//        series.add(2, 2);
//        series.add(3, 3);
//        series.add(4, 4);
//
//        XYSeriesCollection dataset = new XYSeriesCollection();
//        dataset.addSeries(series);
//
//        JFreeChart chart = ChartFactory.createXYLineChart(
//                "Line Chart Example",
//                "X-Axis",
//                "Y-Axis",
//                dataset
//        );
//
//        ChartFrame frame = new ChartFrame("Line Chart", chart);
//        frame.pack();
//        frame.setVisible(true);
//    }
//}
