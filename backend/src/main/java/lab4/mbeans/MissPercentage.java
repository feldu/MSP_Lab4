package lab4.mbeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
@Slf4j
public class MissPercentage implements MissPercentageMBean {
    double missPercentage = 0;

    @Override
    public void updateCounters(long misses, long all) {
        missPercentage = (double) misses / all * 100;
        log.info("miss percentage updated to {}", missPercentage);
        System.err.println(missPercentage);
    }

    @Override
    public double getMissPercentage() {
        return missPercentage;
    }
}
