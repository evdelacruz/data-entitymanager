package com.evdelacruz.samples.dataentitymanager.util.error;

import java.io.Serializable;

public class Error implements Serializable {
    private static final long serialVersionUID = 3196160052157522549L;
    private String code;
    private String detail;

    public Error() {}

    public Error(String code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    //<editor-fold desc="Encapsulation">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    //</editor-fold>
}
