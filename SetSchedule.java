package kr.ac.cnu.computer.adventuredesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import static kr.ac.cnu.computer.adventuredesign.InitialValue.gSchedule;

public class SetSchedule extends AppCompatActivity {

    TextView info;
    CheckBox breakfast;
    CheckBox lunch;
    CheckBox dinner;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_schedule);

        Intent receivedIntent = getIntent();

        int month = receivedIntent.getIntExtra("month", 0);
        int day = receivedIntent.getIntExtra("day", 0);

        info = findViewById(R.id.info);
        info.setText(month + "월 " + day + "일 식단 스케줄");

        breakfast = findViewById(R.id.breakfast);
        lunch = findViewById(R.id.lunch);
        dinner = findViewById(R.id.dinner);

        breakfast.setChecked(gSchedule[day][1]);
        lunch.setChecked(gSchedule[day][2]);
        dinner.setChecked(gSchedule[day][3]);

        save = (Button) findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gSchedule[day][1] = breakfast.isChecked();
                gSchedule[day][2] = lunch.isChecked();
                gSchedule[day][3] = dinner.isChecked();

                Toast.makeText(getApplicationContext(), "저장되었습니다", Toast.LENGTH_LONG).show();
            }
        });



    }
}
