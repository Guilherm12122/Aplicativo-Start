package com.example.app_start.others;

import androidx.appcompat.app.AlertDialog;

public class AlertMsg {

    private String msg;

    public void ShowMsg(AlertDialog.Builder alertDialog, String msg){
        alertDialog.setMessage(msg);
        alertDialog.setNeutralButton("Ok", null);
        alertDialog.show();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
