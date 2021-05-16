package lab4.mbeans;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class PointsCounter implements PointsCounterMBean {
    @Override
    public int getPointsCnt() {
        return 0;
    }

    @Override
    public int getHitCnt() {
        return 0;
    }
}
