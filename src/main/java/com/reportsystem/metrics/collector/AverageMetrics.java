package com.reportsystem.metrics.collector;
import lombok.Getter;
import lombok.Setter;

public class AverageMetrics {
    @Getter @Setter private double cpuUsed;
    @Getter @Setter private double memoryUsed;
    @Getter @Setter private double fileDescriptors;
}
