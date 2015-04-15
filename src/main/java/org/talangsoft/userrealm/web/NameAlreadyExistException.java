package org.talangsoft.userrealm.web;

public class NameAlreadyExistException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Name '%s' already exist";

    private String name;

    public NameAlreadyExistException(String name) {
        super(String.format(MESSAGE_FORMAT, name));

        this.name = name;
    }

    public String getName() {
        return name;
    }
}