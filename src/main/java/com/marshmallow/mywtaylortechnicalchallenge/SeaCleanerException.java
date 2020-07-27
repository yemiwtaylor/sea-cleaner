package com.marshmallow.mywtaylortechnicalchallenge;

import org.springframework.http.HttpStatus;

public class SeaCleanerException extends RuntimeException {

  private final HttpStatus httpStatus;
  private final ErrorResponse errorResponse;

  public SeaCleanerException(
      HttpStatus httpStatus,
      ErrorResponse errorResponse
  ) {
    this.httpStatus = httpStatus;
    this.errorResponse = errorResponse;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }

  public static class BadRequestError extends SeaCleanerException {

    public BadRequestError(String message) {
      super(HttpStatus.BAD_REQUEST, new ErrorResponse(message));
    }
  }

  public static class ErrorResponse {

    private final String message;

    public ErrorResponse(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }
}
