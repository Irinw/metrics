package com.reportsystem.metrics.collector;

import com.reportsystem.metrics.utils.ProcessUtils;

public class ProcessMetricsCollector {

    public ProcessMetrics collect(int pid){
        ProcessMetrics processMetrics = new ProcessMetrics();
        processMetrics.setMemoryUsed(ProcessUtils.memoryUtilizationPerProcess(pid));
        processMetrics.setCpuUsed(ProcessUtils.getCpuUtilizationPerProcess(pid));
        processMetrics.setFileDescriptors(ProcessUtils.fileDescriptorUtilizationPerProcess(pid));
        return processMetrics;
    }
}
