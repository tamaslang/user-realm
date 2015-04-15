package org.talangsoft.userrealm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talangsoft.rest.devtools.logging.Loggable;
import org.talangsoft.rest.devtools.web.RestException;
import org.talangsoft.userrealm.api.CreateRealmDTO;
import org.talangsoft.userrealm.api.ErrorDTO;
import org.talangsoft.userrealm.api.RestErrors;
import org.talangsoft.userrealm.api.UserRealmDTO;
import org.talangsoft.userrealm.domain.UserRealm;
import org.talangsoft.userrealm.service.UserRealmService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.util.function.Function;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/service/user/realm")
public class UserRealmResourceImpl implements UserRealmResource, Loggable{

    @Autowired
    private UserRealmService userRealmService;

    private Function<UserRealm,UserRealmDTO> userRealmToDTOConverter = entity -> new UserRealmDTO(String.valueOf(entity.getId()),entity.getName(),entity.getDescription(),entity.getKey());

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserRealmDTO getById(@PathVariable String id) {
        logger().info("Find user realm by id '{}'",id);
        // TODO validate id!
        UserRealm userRealm = userRealmService.getById(Long.valueOf(id));
        if(userRealm == null){
            throw new RestException(RestErrors.RealmNotFound.toRestError());
        }
        return userRealmToDTOConverter.apply(userRealm);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRealmDTO> create(@RequestBody @Valid CreateRealmDTO createUserRealm) {
        logger().info("Create createUserRealm {}",createUserRealm);

        UserRealm createdRealm = userRealmService.createRealm(createUserRealm.getName(),createUserRealm.getDescription());

        UserRealmDTO userRealmDTO = userRealmToDTOConverter.apply(createdRealm);
        HttpHeaders headers = new HttpHeaders();
        URI location = linkTo(methodOn(this.getClass()).getById(userRealmDTO.getId())).toUri();
        logger().debug("Set header location to: {} ", location);
        headers.setLocation(location);

        return new ResponseEntity<>(userRealmDTO,headers, HttpStatus.CREATED);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex){
        logger().error("Handling entity not found exception", ex);
        return new ResponseEntity<>(new ErrorDTO(RestErrors.RealmNotFound.name()),RestErrors.RealmNotFound.getHttpStatus());
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleInvalidIdException(NumberFormatException ex){
        logger().error("Handling invalid id exception", ex);
        return new ResponseEntity<>(new ErrorDTO(RestErrors.InvalidArgument.name()),RestErrors.InvalidArgument.getHttpStatus());
    }

    @ExceptionHandler(NameAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleNameAlreadyExistException(NameAlreadyExistException ex){
        logger().error("name already exist exception", ex);
        return new ResponseEntity<>(new ErrorDTO(RestErrors.DuplicateRealmName.name()),RestErrors.DuplicateRealmName.getHttpStatus());
    }


}
