package lab4.mbeans;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class MissPercentage implements MissPercentageMBean {
    final PointsCounterMBean pointsCounterMBean;

    public MissPercentage(PointsCounterMBean pointsCounterMBean) {
        this.pointsCounterMBean = pointsCounterMBean;
    }

    @Override
    public long getMissPercentage() {
        return pointsCounterMBean.getMissCnt() / pointsCounterMBean.getPointsCnt() * 100;
    }
}
