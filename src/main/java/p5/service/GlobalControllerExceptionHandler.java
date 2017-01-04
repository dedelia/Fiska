package p5.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import p5.exceptions.DataMissingException;
import p5.view.StatusCode;


/**
 * Created by dtristu on 04.01.2017.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = DataMissingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public StatusCode handleDataMissingException(DataMissingException e) {
        StatusCode code = new StatusCode();
        code.setErrorCode(e.getErrCode());
        code.setErrorMesage(e.getErrMsg());
        return code;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public StatusCode handleException(Exception e) {
        StatusCode code = new StatusCode();
        code.setErrorCode("500");
        code.setErrorMesage("Something went wrong");
        return code;
    }

}
