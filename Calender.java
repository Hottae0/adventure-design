package kr.ac.cnu.computer.adventuredesign;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Calender extends AppCompatActivity {
    public CalendarView calendarView;

    Button pButton;
    Button gButton;

    public final static int Request_Code_Calender = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                Intent intent = new Intent(getApplicationContext(), SetSchedule.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);

                Toast.makeText(getApplicationContext(),year+" " + (month+1) + " " + day, Toast.LENGTH_LONG).show();

                intent.putExtra("year", year);
                intent.putExtra("month", month + 1);
                intent.putExtra("day", day);


                startActivityForResult(intent, Request_Code_Calender);
            }
        });



    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == Request_Code_Calender){
            if(intent != null){

            }
        }

    }

}
