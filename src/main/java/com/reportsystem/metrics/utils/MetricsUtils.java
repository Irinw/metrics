package com.reportsystem.metrics.utils;

import com.reportsystem.metrics.collector.AverageMetrics;
import com.reportsystem.metrics.collector.ProcessMetrics;

import java.util.ArrayList;
import java.util.List;

public class MetricsUtils {
    public static List<List<String>> convertSystemMetricsToCsvFormat(List<ProcessMetrics> metrics){
        List<List<String>> output = new ArrayList<>();
        for(ProcessMetrics metric: metrics){
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(metric.getCpuUsed()));
            row.add(String.valueOf(metric.getMemoryUsed()));
            row.add(String.valueOf(metric.getFileDescriptors()));
            output.add(row);
        }
        return output;
    }
}
