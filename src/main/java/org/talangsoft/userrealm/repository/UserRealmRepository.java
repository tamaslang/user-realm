package org.talangsoft.userrealm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talangsoft.userrealm.domain.UserRealm;

public interface UserRealmRepository extends JpaRepository<UserRealm,Long> {

    UserRealm findByName(String name);

}
