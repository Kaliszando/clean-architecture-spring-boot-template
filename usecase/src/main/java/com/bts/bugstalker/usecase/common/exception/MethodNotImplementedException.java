package com.bts.bugstalker.usecase.common.exception;

public class MethodNotImplementedException extends RuntimeException {

    public MethodNotImplementedException(String errorMessage) {
        super(errorMessage);
    }

    public MethodNotImplementedException() {
        super();
    }
}
