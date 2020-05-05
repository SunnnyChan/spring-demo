package me.sunny.demo.spring.web.controlleradvice.exception;

/**
 * @author sunnnychan@gmail.com
 */
public class ScException extends RuntimeException {

    private String msg;

    public ScException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ScException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
