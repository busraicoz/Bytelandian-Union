package com.byteland.exception;

import java.io.IOException;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */

public class InvalidInputException extends IOException {

    //Exception for invalid user inputs
    public InvalidInputException(String message) {
        super(message);
    }
}
