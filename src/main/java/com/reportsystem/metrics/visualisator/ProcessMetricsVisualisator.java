package com.reportsystem.metrics.visualisator;

import com.reportsystem.metrics.calculator.ProcessMetricsCalculator;
import com.reportsystem.metrics.collector.AverageMetrics;
import com.reportsystem.metrics.collector.ProcessMetrics;
import com.reportsystem.metrics.utils.MetricsUtils;

import java.util.List;

public class ProcessMetricsVisualisator {

    public void displayAverageMetrics(List<ProcessMetrics> metrics){
        ProcessMetricsCalculator processMetricsCalculator = new ProcessMetricsCalculator();
        AverageMetrics averageMetrics = processMetricsCalculator.calculateAverageMetrics(metrics);
        System.out.println("Average Memory Used: " + averageMetrics.getMemoryUsed());
        System.out.println("Average Cpu Used: " + averageMetrics.getCpuUsed());
        System.out.println("Average File Descriptors: " + averageMetrics.getFileDescriptors());
    }
}
