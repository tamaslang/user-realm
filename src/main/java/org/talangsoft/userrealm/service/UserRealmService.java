package org.talangsoft.userrealm.service;

import org.talangsoft.userrealm.domain.UserRealm;

/**
 * User realm service to get and create realms
 */
public interface UserRealmService {

    /**
     * Get a realm by id
     *
     * @param id the realm id
     *
     *
     * @throws javax.persistence.EntityNotFoundException if no entitiy found for the id
     * @return the realm for the given id
     */
    UserRealm getById(Long id);

    /**
     * Create a realm with name and description
     *
     * @param name the name to create realm with
     * @param description the description to create realm with
     *
     * @throws org.talangsoft.userrealm.web.NameAlreadyExistException if the realm with name already exists
     * @return the created realm with additional key and id
     */
    UserRealm createRealm(String name, String description);
}
