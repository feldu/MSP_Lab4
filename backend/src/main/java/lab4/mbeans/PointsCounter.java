package lab4.mbeans;

import lab4.entities.Point;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.List;

@ManagedResource
@Component
@Slf4j
public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private int sequenceCounter = 0;
    long pointsCnt = 0;
    long missCnt = 0;

    public void updateCounters(List<Point> points) {
        missCnt = points.stream().filter(point -> point.getResult().equals("Не попала")).count();
        pointsCnt = points.size();
        log.info("Counters updated. {} misses from {} points", missCnt, pointsCnt);
        if (pointsCnt % 5 == 0) {
            Notification notification = new Notification(
                    "pointsCountIsMultipleOfFive", this, sequenceCounter++,
                    System.currentTimeMillis(), "Points count is multiple of five"
            );
            this.sendNotification(notification);
            log.info("pointsCountIsMultipleOfFive id: " + sequenceCounter);
        }
        log.error(missCnt + " " + pointsCnt);
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
