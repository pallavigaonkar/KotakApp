package myapp.winsofttech.com.kotak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_AD_ID;

    Button button_AD_ID_Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_AD_ID=(EditText)findViewById(R.id.AD_ID);
        button_AD_ID_Submit=(Button)findViewById(R.id.button_AD_ID_Submit);



        button_AD_ID_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_AD_ID.getText().toString().equals("123")){
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    i.putExtra("username","winsoft");
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
