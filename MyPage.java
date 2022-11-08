package kr.ac.cnu.computer.adventuredesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MyPage extends AppCompatActivity {
    public final static int Request_Code_Back = 3;
    public final static int Request_Code_Calendar= 4;
    public final static int Request_Code_info = 7;
    Button BBinfo;
    Button InitialReset;
    Button calender;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_page);

        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String birth = receivedIntent.getStringExtra("birth");


        // 일단 나중에

        BBinfo = (Button) findViewById(R.id.button1);
        BBinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, Request_Code_info);
            }
        });


        InitialReset = (Button) findViewById(R.id.button2);
        InitialReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InitialValue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);

                intent.putExtra("username", username);
                intent.putExtra("birth", birth);
                startActivityForResult(intent, Request_Code_Back);
            }
        });

        calender = (Button) findViewById(R.id.button3);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calender.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, Request_Code_Calendar);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == Request_Code_Back){
            if(intent != null){

            }
        }else if(requestCode == Request_Code_Calendar){
            if(intent != null){

            }
        }else if(requestCode == Request_Code_info){
            if(intent != null){

            }
        }

    }


}
