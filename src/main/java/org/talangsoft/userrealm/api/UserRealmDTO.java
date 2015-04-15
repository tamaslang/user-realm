package org.talangsoft.userrealm.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.talangsoft.rest.devtools.domain.DTO;

public class UserRealmDTO extends DTO{
    private String id;
    private String name;
    private String description;
    private String key;

    @JsonCreator
    public UserRealmDTO(@JsonProperty("id") String id,
                        @JsonProperty("name") String name,
                        @JsonProperty("description") String description,
                        @JsonProperty("key") String key) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }
}
