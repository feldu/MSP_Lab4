package lab4.mbeans;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class MissPercentage implements MissPercentageMBean {
    double missPercentage = 0;

    @Override
    public void updateCounters(long misses, long all) {
        missPercentage = (double) misses / all * 100;
        System.err.println(missPercentage);
    }

    @Override
    public double getMissPercentage() {
        return missPercentage;
    }
}
