package me.safuanov;

public class UserNonUniqueException extends RuntimeException {
    public UserNonUniqueException(String message) {
        super(message);
    }
}
