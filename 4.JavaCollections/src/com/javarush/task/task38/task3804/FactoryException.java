package com.javarush.task.task38.task3804;

public class FactoryException {
    public static Throwable createException(Enum e) throws Exception {

        if (ApplicationExceptionMessage.UNHANDLED_EXCEPTION.equals(e)) {
            return new Exception("Unhandled exception");
        } else if (ApplicationExceptionMessage.SOCKET_IS_CLOSED.equals(e)) {
            return new Exception("Socket is closed");
        } else if (DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT.equals(e)) {
            return new RuntimeException("No result due to timeout");
        } else if (DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS.equals(e)) {
            return new RuntimeException("Not enough connections");
        } else if (UserExceptionMessage.USER_DOES_NOT_EXIST.equals(e)) {
            return   new Error("User does not exist");
        } else if (UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS.equals(e)) {
            return   new Error("User does not have permissions");
        }
        return new IllegalArgumentException();
    }

//    static Throwable getException(Enum enumm) {
//        if (enumm == null) return new IllegalArgumentException();
//        String message = enumm.name().toLowerCase().replaceAll("[_]", " ");
//        String first = message.substring(0, 1).toUpperCase();
//        message = first + message.substring(1);
//
//        switch (enumm.getClass().getSimpleName()) {
//            case "ApplicationExceptionMessage":
//                return new Exception(message);
//            case "DatabaseExceptionMessage":
//                return new RuntimeException(message);
//            case "UserExceptionMessage":
//                return new Error(message);
//            default:
//                return new IllegalArgumentException();
//        }
//    }
}
