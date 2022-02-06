package com.OrangeHRM.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/FeatureFiles",
        glue = "src/test/java/com/OrangeHRM/StepDefinitions",
        dryRun = true,
        //tags = "@Sanity",
        plugin = {"pretty","html:src/Reports/CucumberReport.html"}
)

public class TestRunner {
}
