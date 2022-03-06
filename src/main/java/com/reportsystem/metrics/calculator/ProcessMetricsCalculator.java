package com.reportsystem.metrics.calculator;

import com.reportsystem.metrics.collector.AverageMetrics;
import com.reportsystem.metrics.collector.ProcessMetrics;
import java.util.List;

public class ProcessMetricsCalculator {
    public AverageMetrics calculateAverageMetrics(List<ProcessMetrics> metrics){
        AverageMetrics averageMetrics = new AverageMetrics();
        double cpuUsed = 0;
        double memoryUsed = 0;
        double fileDescriptors = 0;
        double size = metrics.size();
        for(ProcessMetrics metric: metrics){
            cpuUsed +=metric.getCpuUsed();
            memoryUsed +=metric.getMemoryUsed();
            fileDescriptors +=metric.getFileDescriptors();
        }
        averageMetrics.setCpuUsed(Math.round(cpuUsed/size));
        averageMetrics.setMemoryUsed(Math.round(memoryUsed/size));
        averageMetrics.setFileDescriptors(Math.round(fileDescriptors/size));
        return averageMetrics;
    }
}
