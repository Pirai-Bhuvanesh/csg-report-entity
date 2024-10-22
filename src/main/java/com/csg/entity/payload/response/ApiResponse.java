package com.csg.entity.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private String message;

    private Boolean status;

    private String statusCode;

    public boolean isStatus() {
        return status != null && status; // Handle potential null case
    }

}
