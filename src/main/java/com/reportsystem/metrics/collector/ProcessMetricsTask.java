package com.reportsystem.metrics.collector;
import java.util.List;

public class ProcessMetricsTask implements Runnable {
    private int pid;
    private ProcessMetricsCollector collector;
    private List<ProcessMetrics> processMetrics;

    public ProcessMetricsTask(int pid, List<ProcessMetrics> processMetrics){
        this.pid = pid;
        this.collector = new ProcessMetricsCollector();
        this.processMetrics = processMetrics;
    }

    @Override
    public void run() {
        ProcessMetrics metrics = collector.collect(this.pid);
        this.processMetrics.add(metrics);
    }
}
