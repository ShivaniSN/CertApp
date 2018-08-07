package apps.com.certapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NotificationCompat;
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
                    addNotification();
                    Intent i = new Intent(Activity_Main.this, Activity_Dashboard.class);
                    startActivity(i);
                }
            }
        });
    }

    private void addNotification() {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "Questionnaire App",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Logged in succesfully");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("Notification Example") // title for notification
                .setContentText("This is a trial of notification")// message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), Activity_AddQuestion.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }
}
