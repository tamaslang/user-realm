package org.talangsoft.userrealm.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:userrealm.integration",
        tags = {"@restApiIntegration", "~@ignore"},
        format = {"html:target/cucumber-report/userRealmIntegration",
                "json:target/cucumber-report/userRealmIntegration.json"})
public class UserRealmIntegrationTest {
}
