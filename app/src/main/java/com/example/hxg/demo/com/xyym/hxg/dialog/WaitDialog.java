package com.example.hxg.demo.com.xyym.hxg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hxg.demo.R;


public class WaitDialog extends Dialog {

    private TextView tips_loading_msg;

    private String message = null;

    public WaitDialog(Context context, String message) {
        super(context, R.style.dialog_windowFullscreen);
        this.message = message;
        this.setCancelable(false);
    }

	public WaitDialog(Context context, int theme, String message) {
		super(context, R.style.dialog_windowFullscreen);
		this.message = message;
		this.setCancelable(false);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_tips_loading);
        tips_loading_msg = (TextView) findViewById(R.id.tips_loading_msg);
        tips_loading_msg.setText(this.message);
    }

    public void setText(String message) {
        this.message = message;
        tips_loading_msg.setText(this.message);
    }

    public void setText(int resId) {
        setText(getContext().getResources().getString(resId));
    }

}
