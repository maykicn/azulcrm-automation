package com.azulcrm.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"html:target/failed-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/azulcrm/stepdefinitions",
        tags = "@EUG18-288",
        dryRun =false
)
public class CukesRunner {
}
