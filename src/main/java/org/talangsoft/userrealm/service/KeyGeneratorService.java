package org.talangsoft.userrealm.service;

/**
 * Key generator service
 * Generates a 32 character long unique key based on the given name
 */
public interface KeyGeneratorService {
    /**
     * Generate unique key for the given name
     *
     * @param name the name to generate the key for
     *
     * @return 32 character long unique key
     */
    String generateKey(String name);
}
