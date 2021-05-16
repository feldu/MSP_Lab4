package lab4.mbeans;

import lab4.entities.Point;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

@ManagedResource
@Component
public class PointsCounter implements PointsCounterMBean {
    long pointsCnt = 0;
    long missCnt = 0;

    public void updateCounters(List<Point> points) {
        missCnt = points.stream().filter(point -> point.getResult().equals("Не попала")).count();
        pointsCnt = points.size();
        System.err.println(missCnt + " " + pointsCnt);
    }

    @Override
    public long getPointsCnt() {
        return pointsCnt;
    }

    @Override
    public long getMissCnt() {
        return missCnt;
    }
}
