package kr.ac.cnu.computer.adventuredesign;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final int Request_Code_Login = 1;
    EditText name;
    EditText password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.login);
        password =findViewById(R.id.password);

        Login = (Button) findViewById(R.id.LoginButton);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String birth = password.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);

                intent.putExtra("username", username);
                intent.putExtra("birth", birth);
                startActivityForResult(intent, Request_Code_Login);

            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == Request_Code_Login){

            if(intent != null){
                Toast toast = Toast.makeText(getBaseContext(), "감사합니다", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

}