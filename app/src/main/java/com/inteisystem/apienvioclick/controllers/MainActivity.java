package com.inteisystem.apienvioclick.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.inteisystem.apienvioclick.R;

import com.google.android.material.textfield.TextInputLayout;
import com.inteisystem.apienvioclick.commons.Common;

public class MainActivity extends AppCompatActivity {
    TextView textoInicio;
    EditText edtKey;
    private TextInputLayout txtLayoutKey;
    Button buttonKey;
    private Common commons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {
        textoInicio = findViewById(R.id.txtInicio);
        edtKey = findViewById(R.id.txtKey);
        buttonKey = findViewById(R.id.btnKey);
        txtLayoutKey = findViewById(R.id.input_layout_key);
        commons = new Common(this);
    }


    public void validarKey(View view) {
        if (commons.validSpaces(edtKey)){
            txtLayoutKey.setErrorEnabled(false);
            commons.saveApiKey(edtKey.getText().toString());
            //commons.goToNextActivity(MenuActivity.class); TODO menu class
        }else{
            txtLayoutKey.setError(getString(R.string.err_msg_key));
        }

    }

    public void generarKey(View view){
        Common.showLoading(this);
        commons.goToNextActivity(WebViewActivity.class);
        Common.hideLoading();
    }







}