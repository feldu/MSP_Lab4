package lab4.mbeans;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class HitPercentage implements HitPercentageMBean {
    @Override
    public int getMissPercentage() {
        return 0;
    }
}
