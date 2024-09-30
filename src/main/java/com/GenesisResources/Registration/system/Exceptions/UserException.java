package com.GenesisResources.Registration.system.Exceptions;
import java.lang.Exception;

public class UserException extends RuntimeException {
    public UserException() {
        super("An error occurred related to the user.");
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return String.format("UserException: %s", getMessage());
    }

}
