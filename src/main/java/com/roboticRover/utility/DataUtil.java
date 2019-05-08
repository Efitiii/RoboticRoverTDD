package com.roboticRover.utility;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

@Component
public class DataUtil implements  IDataUtil{


    @Override
    public List<String> readFile(String filePath) {

        File file= new File(filePath);
        BufferedReader br= null;
        List<String> listOfInputs= new ArrayList<>();

        try{
            br= new BufferedReader(new FileReader(file));

            String input;
            while ((input = br.readLine()) != null) {
                if (!input.isEmpty()) {
                    listOfInputs.add(input);
                }

            }


        }
        catch (IOException e){
            e.printStackTrace();
        }

        return listOfInputs;
    }

    @Override
    public void classifyInput(List<String> listInput) {

       for (int i=0;i<listInput.size();i++){

       }

    }


}
