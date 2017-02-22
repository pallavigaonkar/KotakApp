package myapp.winsofttech.com.kotak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button button_Login;
    EditText editText_password;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        String uname=intent.getStringExtra("username");

        button_Login=(Button)findViewById(R.id.button_Login);
        username=(TextView)findViewById(R.id.username);
        editText_password=(EditText)findViewById(R.id.editText_password);
        if(uname!=null){
            username.setText("Welcome :"+uname);
        }
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_password.getText().toString().equals("abcc")){
                    Intent i = new Intent(getApplicationContext(),Home.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
