package p5.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dtristu on 03.01.2017.
 */
@ResponseStatus
public class DataMissingException extends RuntimeException{
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DataMissingException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
