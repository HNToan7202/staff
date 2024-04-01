package com.example.staff.model;

import com.example.staff.util.ErrorCodeEnum;
import lombok.Data;

@Data
public class ActionResult {
    private ErrorCodeEnum errorCode;
    private Object data ;
}
