package org.talangsoft.userrealm.service;

import org.springframework.stereotype.Service;

/**
 * Mocked service to return with dummy key
 */
@Service
public class DummyKeyGeneratorService  implements KeyGeneratorService{

    public static final String DUMMY_KEY = "01234567890123456789012345678912";

    @Override
    public String generateKey(String name) {
        return DUMMY_KEY;
    }
}
