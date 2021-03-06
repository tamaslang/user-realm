define({ "api": [
  {
    "type": "post",
    "url": "/service/user/realm",
    "title": "Create a user realm",
    "name": "create",
    "group": "UserRealmResource",
    "description": "<p>Create a new user realm with name and description</p> ",
    "version": "1.0.0",
    "success": {
      "fields": {
        "201": [
          {
            "group": "201",
            "type": "String",
            "optional": false,
            "field": "location",
            "description": "<p>The location of the new user realm; sent in header</p> "
          }
        ]
      }
    },
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\":\"uniqueusername\",\n  \"description\":\"A description...\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "400": [
          {
            "group": "400",
            "optional": false,
            "field": "DuplicateRealmName",
            "description": "<p>The realm for name already exists</p> "
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 400 Bad Request\n{\"code\":\"DuplicateRealmName\"}",
          "type": "json"
        }
      ]
    },
    "filename": "/Users/admin/Work/Repos/user-realm/src/main/java/org/talangsoft/userrealm/web/UserRealmResource.java",
    "groupTitle": "UserRealmResource"
  },
  {
    "type": "get",
    "url": "/service/user/realm/{id}",
    "title": "Get user realm by it's id",
    "name": "getById",
    "group": "UserRealmResource",
    "description": "<p>Get a user realm by it&#39;s id</p> ",
    "version": "1.0.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>The number that identifies the user realm</p> "
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "UserRealmDTO",
            "optional": false,
            "field": "userRealmDTO",
            "description": "<p>The userRealm DTO</p> "
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n    {\n      \"id\":\"1000000\",\n      \"name\":\"\",\n      \"description\":\"A description\",\n      \"key\":\"generated key\",\n    }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "400": [
          {
            "group": "400",
            "optional": false,
            "field": "InvalidArgument",
            "description": "<p>The given id is not a valid number</p> "
          }
        ],
        "404": [
          {
            "group": "404",
            "optional": false,
            "field": "RealmNotFound",
            "description": "<p>The realm was not found</p> "
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not found\n{\"code\":\"RealmNotFound\"}",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 400 Bad Request\n{\"code\":\"InvalidArgument\"}",
          "type": "json"
        }
      ]
    },
    "filename": "/Users/admin/Work/Repos/user-realm/src/main/java/org/talangsoft/userrealm/web/UserRealmResource.java",
    "groupTitle": "UserRealmResource"
  }
] });