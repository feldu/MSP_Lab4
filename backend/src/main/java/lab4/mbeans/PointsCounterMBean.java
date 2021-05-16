package lab4.mbeans;

import lab4.entities.Point;

import java.util.List;

public interface PointsCounterMBean {
    void updateCounters(List<Point> points);

    long getPointsCnt();

    long getMissCnt();
}
