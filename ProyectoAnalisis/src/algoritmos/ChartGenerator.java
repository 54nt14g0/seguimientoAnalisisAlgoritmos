package algoritmos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ChartGenerator extends JFrame {

    public ChartGenerator(String chartTitle, String xLabel, String yLabel, DefaultCategoryDataset dataset) {
        super(chartTitle);

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                xLabel,
                yLabel,
                dataset
        );

        // Obtener el gráfico de barras y su trazado
        CategoryPlot plot = barChart.getCategoryPlot();

        // Configurar el eje Y para que no use notación científica
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setNumberFormatOverride(new DecimalFormat("#,###.00")); // Mostrar con dos decimales

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    // Método para crear el dataset de los tiempos de ejecución
    public static DefaultCategoryDataset createDataset(String[] algorithms, long[] times) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < algorithms.length; i++) {
            double timeInMillis = times[i]; 
            dataset.addValue(timeInMillis, algorithms[i], algorithms[i]);
        }

        return dataset;
    }
}