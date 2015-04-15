package org.talangsoft.userrealm.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.talangsoft.rest.devtools.domain.DTO;

public class CreateRealmDTO extends DTO{
    private String name;
    private String description;

    @JsonCreator
    public CreateRealmDTO(@JsonProperty("name") String name,
                          @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
