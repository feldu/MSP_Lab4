package lab4.mbeans;

import lab4.entities.Point;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

@ManagedResource
@Component
@Slf4j
public class PointsCounter implements PointsCounterMBean {
    long pointsCnt = 0;
    long missCnt = 0;

    public void updateCounters(List<Point> points) {
        missCnt = points.stream().filter(point -> point.getResult().equals("Не попала")).count();
        pointsCnt = points.size();
        log.info("Counters updated. {} misses from {} points", missCnt, pointsCnt);
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
