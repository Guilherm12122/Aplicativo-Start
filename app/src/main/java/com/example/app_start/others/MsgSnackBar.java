package com.example.app_start.others;

import android.graphics.Color;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MsgSnackBar {

    private Snackbar snackbar;

    public MsgSnackBar(Snackbar snackbar){
        this.snackbar = snackbar;
    }

    public void ShowMsg(View view, String msg){
        snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }
}
