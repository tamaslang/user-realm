package org.talangsoft.userrealm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talangsoft.rest.devtools.logging.Loggable;
import org.talangsoft.userrealm.domain.UserRealm;
import org.talangsoft.userrealm.repository.UserRealmRepository;
import org.talangsoft.userrealm.web.NameAlreadyExistException;

import javax.transaction.Transactional;

@Service
public class UserRealmServiceImpl implements Loggable, UserRealmService {

    @Autowired
    UserRealmRepository userRealmRepo;

    @Autowired
    KeyGeneratorService keyGeneratorService;

    public UserRealm getById(Long id){
        return userRealmRepo.getOne(id);
    }

    @Transactional
    public UserRealm createRealm(String name, String description){
        UserRealm realm = userRealmRepo.findByName(name);
        if(realm != null){
            throw new NameAlreadyExistException(name);
        }
        UserRealm userRealm = new UserRealm(null,name,description,keyGeneratorService.generateKey(name));
        return userRealmRepo.save(userRealm);
    }

}
