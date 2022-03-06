package com.reportsystem.metrics;

import com.reportsystem.metrics.collector.ProcessMetrics;
import com.reportsystem.metrics.collector.ProcessMetricsTask;
import com.reportsystem.metrics.reports.manager.ReportsManager;
import com.reportsystem.metrics.utils.ProcessUtils;
import com.reportsystem.metrics.visualisator.ProcessMetricsVisualisator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class App {
    final static String EXCEL_FINAL_NAME = "METRICS_FILE.csv";

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.print("Please enter process name: ");
        Scanner scan = new Scanner(System.in);
        String processName = scan.nextLine();
        int pid = ProcessUtils.getProcessPidByProcessName(processName);

        System.out.print("Please enter the overall duration in seconds : ");
        int duration = scan.nextInt();

        System.out.print("Please enter the sampling interval in seconds : ");
        // to-do: Parameter should be optional
        int interval = scan.nextInt();
        scan.close();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        List<ProcessMetrics> processMetrics = new ArrayList<>();
        ProcessMetricsTask task = new ProcessMetricsTask(pid, processMetrics);
        executor.scheduleAtFixedRate(task, 0, interval, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(duration);
        executor.shutdown();

        ReportsManager reportsManager = new ReportsManager();
        reportsManager.createSystemMetricsReport(EXCEL_FINAL_NAME, processMetrics);
        ProcessMetricsVisualisator visualisator = new ProcessMetricsVisualisator();
        visualisator.displayAverageMetrics(processMetrics);
    }
}
