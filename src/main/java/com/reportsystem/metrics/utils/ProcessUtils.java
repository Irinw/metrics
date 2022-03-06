package com.reportsystem.metrics.utils;

public class ProcessUtils {
    public static int getProcessPidByProcessName(String processName) {
        // to-do get memory usage using oshi-core
        return 605;
    }
    public static double getCpuUtilizationPerProcess(int processId) {
        // to-do get cpu data using oshi-core
        return 10;
    }

    public static int fileDescriptorUtilizationPerProcess(int pid) {
        // to-do: get file descriptors using oshi-core
        return 10;
    }

    public static double memoryUtilizationPerProcess(int pid) {
        return 10.1;
    }
}
