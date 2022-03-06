package com.reportsystem.metrics.reports.manager;

import com.reportsystem.metrics.collector.ProcessMetrics;
import com.reportsystem.metrics.reports.generators.ReportGenerator;
import com.reportsystem.metrics.utils.MetricsUtils;

import java.util.List;

public class ReportsManager {
    public void createSystemMetricsReport(String path, List<ProcessMetrics> metrics){
        List<List<String>> parameters = MetricsUtils.convertSystemMetricsToCsvFormat(metrics);
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateCsvReport(path, parameters);
    }

}
