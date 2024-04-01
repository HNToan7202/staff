package com.example.staff.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseBuild {
    public ResponseModel build(ActionResult actionResult) {
        return new ResponseModel(actionResult.getErrorCode(), actionResult.getData());
    }

}
