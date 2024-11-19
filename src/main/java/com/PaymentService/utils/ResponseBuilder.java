package com.PaymentService.utils;

import com.PaymentService.dto.Response;
import org.springframework.http.HttpStatus;

public final class ResponseBuilder {
    public ResponseBuilder() {
    }
    public static Response getSuccessResponse(HttpStatus status,Object content,String message) {
        Response response = new Response();
        response.setStatusCode(status.value());
        response.setStatus(status.getReasonPhrase());
        response.setMessage(message);
        response.setContent(content);
        return response;

    }
    public static Response getFailResponse(HttpStatus status,Object content,String message) {
        Response response = new Response();
        response.setStatusCode(status.value());
        response.setStatus(status.getReasonPhrase());
        response.setMessage(message);
        response.setContent(content);
        return response;
    }


}
