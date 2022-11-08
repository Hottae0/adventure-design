package kr.ac.cnu.computer.adventuredesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class InitialValue  extends AppCompatActivity {
    public final static int Request_Code_Initial = 2;
    CheckBox patientCheckBox;
    CheckBox pBreakfast;
    CheckBox pLunch;
    CheckBox pDinner;
    CheckBox guardianCheckBox;
    CheckBox gBreakfast;
    CheckBox gLunch;
    CheckBox gDinner;
    Button saveInitial;

    public static boolean[][] pSchedule = new boolean[30][4];
    public static boolean[][] gSchedule = new boolean[30][4];

    public static boolean pCheck;
    public static boolean PB;
    public static boolean PL;
    public static boolean PD;

    public static boolean gCheck;
    public static boolean GB;
    public static boolean GL;
    public static boolean GD;
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.initial_value);

            Intent receivedIntent = getIntent();
            String username = receivedIntent.getStringExtra("username");
            String birth = receivedIntent.getStringExtra("birth");

            setInitial();

        }

    protected void setInitial(){
        patientCheckBox =(CheckBox) findViewById(R.id.patientCheckBox);
        pBreakfast = (CheckBox) findViewById(R.id.pBreakfast);
        pLunch =(CheckBox) findViewById(R.id.pLunch);
        pDinner = (CheckBox) findViewById(R.id.pDinner);

        patientCheckBox.setChecked(true);
        pBreakfast.setChecked(true);
        pLunch.setChecked(true);
        pDinner.setChecked(true);

        guardianCheckBox = (CheckBox) findViewById(R.id.guardianCheckBox);
        gBreakfast =(CheckBox) findViewById(R.id.gBreakfast);
        gLunch =(CheckBox) findViewById(R.id.gLunch);
        gDinner = (CheckBox) findViewById(R.id.gDinner);

        saveInitial = (Button) findViewById(R.id.SaveInitial);
        saveInitial.setOnClickListener(new View.OnClickListener() { // 저장하기
            @Override
            public void onClick(View view) {
                pCheck = patientCheckBox.isChecked();
                PB = pBreakfast.isChecked();
                PL = pLunch.isChecked();
                PD = pDinner.isChecked();

                for(int i = 0; i < pSchedule.length; i++){
                    pSchedule[i][0] = pCheck;
                    pSchedule[i][1] = PB;
                    pSchedule[i][2] = PL;
                    pSchedule[i][3] = PD;
                }

                gCheck = guardianCheckBox.isChecked();
                GB = gBreakfast.isChecked();
                GL = gLunch.isChecked();
                GD = gDinner.isChecked();

                for(int i = 0; i < gSchedule.length; i++){
                    gSchedule[i][0] = gCheck;
                    gSchedule[i][1] = GB;
                    gSchedule[i][2] = GL;
                    gSchedule[i][3] = GD;
                }


                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);

                intent.putExtra("pCheck", pCheck);
                intent.putExtra("PB", PB);
                intent.putExtra("PL", PL);
                intent.putExtra("PD", PD);

                intent.putExtra("gCheck", gCheck);
                intent.putExtra("GB", GB);
                intent.putExtra("GL", GL);
                intent.putExtra("GD", GD);

                startActivityForResult(intent, Request_Code_Initial);
            }
        });



        guardianCheckBox.setOnClickListener(new CheckBox.OnClickListener() { //눌릴 때 보이는 메소드
            @Override
            public void onClick(View v) {
                if(guardianCheckBox.isChecked()){
                    gBreakfast.setChecked(false);
                    gLunch.setChecked(false);
                    gDinner.setChecked(false);

                    gBreakfast.setVisibility(View.VISIBLE);
                    gLunch.setVisibility(View.VISIBLE);
                    gDinner.setVisibility(View.VISIBLE);
                }else{
                    gBreakfast.setVisibility(View.INVISIBLE);
                    gLunch.setVisibility(View.INVISIBLE);
                    gDinner.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setInitial();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == Request_Code_Initial){
            if(intent != null){

            }
        }
    }

}
