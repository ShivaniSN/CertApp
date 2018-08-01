package apps.com.certapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Main extends AppCompatActivity {

    EditText editTextUsername,editTextPassword;
    TextInputLayout textInputLayoutUsername,textInputLayoutPaswword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText)findViewById(R.id.et_username);
        editTextPassword = (EditText)findViewById(R.id.et_pwd);
        textInputLayoutUsername = (TextInputLayout)findViewById(R.id.til_Username);
        textInputLayoutPaswword = (TextInputLayout)findViewById(R.id.til_Pwd);
        buttonLogin = (Button)findViewById(R.id.btn_login);
    }
}
