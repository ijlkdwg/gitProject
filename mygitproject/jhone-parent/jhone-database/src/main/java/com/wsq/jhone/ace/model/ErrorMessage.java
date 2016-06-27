package com.wsq.jhone.ace.model;

public class ErrorMessage {
    private String errcode;

    private String errsolution;

    private String errdesc;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode == null ? null : errcode.trim();
    }

    public String getErrsolution() {
        return errsolution;
    }

    public void setErrsolution(String errsolution) {
        this.errsolution = errsolution == null ? null : errsolution.trim();
    }

    public String getErrdesc() {
        return errdesc;
    }

    public void setErrdesc(String errdesc) {
        this.errdesc = errdesc == null ? null : errdesc.trim();
    }

	@Override
	public String toString() {
		return "ErrorMessage [errcode=" + errcode + ", errsolution=" + errsolution + ", errdesc=" + errdesc + "]";
	}
    
}