package com.roboticRover.utility;

import java.util.List;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */
public interface IDataUtil {

    List<String> readFile(String filePath);

    void classifyInput(List<String> listInput);


}
