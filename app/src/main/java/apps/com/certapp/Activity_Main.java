package apps.com.certapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Main extends AppCompatActivity {

    EditText editTextUsername,editTextPassword;
    TextInputLayout textInputLayoutUsername,textInputLayoutPaswword;
    Button buttonLogin;

    public String stringUsername = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText)findViewById(R.id.et_username);
        editTextPassword = (EditText)findViewById(R.id.et_pwd);
        textInputLayoutUsername = (TextInputLayout)findViewById(R.id.til_Username);
        textInputLayoutPaswword = (TextInputLayout)findViewById(R.id.til_Pwd);
        buttonLogin = (Button)findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cnt = 0;

                stringUsername = editTextUsername.getText().toString();

                if (editTextPassword.getText().length() != 4){
                    textInputLayoutPaswword.setError("Enter Valid Password");
                    cnt ++;
                }
                if (editTextUsername.getText().length() < 2){
                    textInputLayoutUsername.setError("Enter Valid Username");
                    cnt ++;
                }

                if (cnt == 0){
                    Intent i = new Intent(Activity_Main.this, Activity_Dashboard.class);
                    startActivity(i);
                }
            }
        });
    }
}
