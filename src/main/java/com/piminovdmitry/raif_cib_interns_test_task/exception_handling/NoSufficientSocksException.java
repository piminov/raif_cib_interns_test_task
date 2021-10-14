package com.piminovdmitry.raif_cib_interns_test_task.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no sufficient socks")
public class NoSufficientSocksException extends RuntimeException {
}
