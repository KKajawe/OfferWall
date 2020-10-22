package com.example.myapplication.UI;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.OfferViewModel;
import com.example.myapplication.remote.responseModel.Offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.myapplication.other.Util.validateUserInput;

public class MainActivity extends AppCompatActivity {
    List<Offers> offerList = new ArrayList<Offers>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnLogin = (Button) findViewById(R.id.btnSubmit);
        EditText edt_appId = (EditText) findViewById(R.id.edtAppId);
        EditText edt_userId = (EditText) findViewById(R.id.edtUserId);
        EditText edt_token = (EditText) findViewById(R.id.edtToken);
        TextView txt_message = (TextView) findViewById(R.id.messageText);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("appid", edt_appId.getText().toString());
                parameters.put("uid", edt_userId.getText().toString());
                parameters.put("hashkey", edt_token.getText().toString());
                if(validateUserInput(edt_appId.getText().toString(), edt_userId.getText().toString(), edt_token.getText().toString())){
                    txt_message.setVisibility(View.VISIBLE);
                    txt_message.setText("Success");
                    txt_message.setTextColor(getResources().getColor(R.color.green));
                }else{
                    txt_message.setVisibility(View.VISIBLE);
                    txt_message.setText("One of the input is invalid");
                    txt_message.setTextColor(getResources().getColor(R.color.red));
                }
               // offerList = ((OfferViewModel) vw).getOfferList(parameters);
            }
        });
    }

}



