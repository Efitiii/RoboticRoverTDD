import com.roboticRover.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Efrem  on 4/20/19
 * @project DistanceOptimizer
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringBootRoboticRoverMovementTests {

    @Test
    public void contextLoads() {
    }

}
