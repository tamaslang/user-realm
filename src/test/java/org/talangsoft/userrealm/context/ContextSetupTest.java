package org.talangsoft.userrealm.context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.talangsoft.userrealm.Application;
import org.talangsoft.userrealm.service.UserRealmService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class ContextSetupTest {
    @Autowired
    private UserRealmService service;

    @Test
    public void testContextSetup(){
        assertNotNull(service);
    }
}
