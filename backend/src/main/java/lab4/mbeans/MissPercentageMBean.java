package lab4.mbeans;

public interface MissPercentageMBean {
    void updateCounters(long misses, long all);

    double getMissPercentage();
}
