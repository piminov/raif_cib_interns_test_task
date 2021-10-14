package com.piminovdmitry.raif_cib_interns_test_task.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectRequestException extends RuntimeException{
}
