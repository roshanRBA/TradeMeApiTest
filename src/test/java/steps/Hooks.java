package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Hooks {
    @Before
    public void initTest(){
        Properties properties = System.getProperties();
        try{
            properties.load(new FileInputStream(new File("src/main/resources/application.properties")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void TestSetup(){

    }

    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("Failed Scenario: " + scenario.getName());
        }
    }
}
