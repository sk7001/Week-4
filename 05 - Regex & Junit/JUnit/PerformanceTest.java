import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
class PerformanceTest {
   Performance perf = new Performance();
   @Test
   @Timeout(value = 2, unit = TimeUnit.SECONDS)
   void testLongRunningTask() throws InterruptedException {
       perf.longRunningTask();
   }
}
