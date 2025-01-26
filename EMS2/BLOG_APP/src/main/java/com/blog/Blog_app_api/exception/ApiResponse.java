package com.blog.Blog_app_api.exception;

import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String message;
    private boolean success;
//    public ApiResponse(){
//
//    }



    public ApiResponse(String message, boolean success){
        this.message=message;
        this.success=success;

    }


}
