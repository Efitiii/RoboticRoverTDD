import com.roboticRover.utility.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.roboticRover.utility.IDataUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Efrem  on 4/12/19
 * @project java-test-project
 */


public class FileReadAndInputTest extends  SpringBootRoboticRoverMovementTests{

    @Autowired
    InputValidator inputValidator;

    @Autowired
    IDataUtil dataUtil;

    List<String> listInput;

    @BeforeEach
    public void setUp(){
        String filePath= "src/resources/input.txt";
        listInput = dataUtil.readFile(filePath);
    }


    @Test
    public void testfileRead() throws IOException {

        assertTrue(listInput.get(0).equals("5 5"));
        assertTrue(listInput.get(1).equals("1 2 N"));
        assertTrue(listInput.get(2).equals("LMLMLMLMM"));
        assertTrue(listInput.get(3).equals("3 3 E"));
        assertTrue(listInput.get(4).equals("MMRMMRMRRM"));

    }

    @Test
    public void testFileInputInitialization() throws IOException {

        String plateaueInput= listInput.get(0);
        assertTrue(inputValidator.validatePlateauInitialization(plateaueInput));

        String robotInput= listInput.get(1);
        assertTrue(inputValidator.validateRobotInitialization(robotInput));


        String motionInput= listInput.get(2);
        assertTrue(inputValidator.validateRobotMotionInput(motionInput));

    }


    @Test
    public void testClassificationOfInput(){
        dataUtil.classifyInput(listInput);


    }



}
