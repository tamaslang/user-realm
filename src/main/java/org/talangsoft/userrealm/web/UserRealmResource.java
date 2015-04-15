package org.talangsoft.userrealm.web;


import org.springframework.http.ResponseEntity;
import org.talangsoft.userrealm.api.CreateRealmDTO;
import org.talangsoft.userrealm.api.UserRealmDTO;

/*
  The user realm resource
 */
public interface UserRealmResource {

    /**
     * @api {get} /service/user/realm/{id} Get user realm by it's id
     * @apiName getById
     * @apiGroup UserRealmResource
     * @apiDescription Get a user realm by it's id
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id The number that identifies the user realm
     *
     * @apiSuccess {UserRealmDTO} userRealmDTO The userRealm DTO
     *
     * @apiSuccessExample Success-Response:
     *     HTTP/1.1 200 OK
     *         {
     *           "id":"1000000",
     *           "name":"",
     *           "description":"A description",
     *           "key":"generated key",
     *         }
     *
     * @apiError (404) RealmNotFound The realm was not found
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not found
     *     {"code":"RealmNotFound"}
     *
     * @apiError (400) InvalidArgument The given id is not a valid number
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 400 Bad Request
     *     {"code":"InvalidArgument"}
     *
     */
    UserRealmDTO getById(String id);

    /**
     * @api {post} /service/user/realm Create a user realm
     * @apiName create
     * @apiGroup UserRealmResource
     * @apiDescription Create a new user realm with name and description
     * @apiVersion 1.0.0
     *
     * @apiSuccess (201) {String} location The location of the new user realm; sent in header
     *
     * @apiParamExample {json} Request-Example:
     *         {
     *           "name":"uniqueusername",
     *           "description":"A description..."
     *         }
     *
     * @apiError (400) DuplicateRealmName The realm for name already exists
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 400 Bad Request
     *     {"code":"DuplicateRealmName"}
     */
    ResponseEntity<UserRealmDTO> create(CreateRealmDTO createRealmDTO);

}
