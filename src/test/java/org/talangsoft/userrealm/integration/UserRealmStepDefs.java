package org.talangsoft.userrealm.integration;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.talangsoft.userrealm.Application;
import org.talangsoft.userrealm.domain.UserRealm;
import org.talangsoft.userrealm.repository.UserRealmRepository;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@DirtiesContext
public class UserRealmStepDefs {
    @Autowired
    UserRealmRepository userRealmRepository;

    private MockRestServiceServer mockServer;

    @Given("^the db is empty$")
    public void clearDb() throws Throwable {
        userRealmRepository.deleteAll();
    }

    @Given("^the following user realms exist:$")
    public void createUserRealms(DataTable userRealms) throws Throwable {
        List<UserRealm> userRealmList = userRealms.asList(UserRealm.class);
        userRealmRepository.save(userRealmList);
    }

}