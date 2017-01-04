package p5.view;

/**
 * Created by dtristu on 03.01.2017.
 */
public class StatusCode {


    String errorMesage;
    String errorCode;

    public StatusCode() {
    }

    public StatusCode(String errorMesage, String id) {
        this.errorMesage = errorMesage;
        this.errorCode = id;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
