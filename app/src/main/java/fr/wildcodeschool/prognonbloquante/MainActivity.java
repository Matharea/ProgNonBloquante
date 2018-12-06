package fr.wildcodeschool.prognonbloquante;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button6 = findViewById(R.id.button);
        Button button4 = findViewById(R.id.button2);
        Button button5 = findViewById(R.id.button3);
        Button button7 = findViewById(R.id.button4);
        Button button8 = findViewById(R.id.button5);
        Button button9 = findViewById(R.id.button6);
        Button button3 = findViewById(R.id.button7);
        Button button2 = findViewById(R.id.button8);
        Button button1 = findViewById(R.id.button9);
        Button button = findViewById(R.id.button10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(0);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(6);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(5);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(9);
            }
        });

    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);

        }
    }

    private void moveNextFloor(int floor) {

        if (floor != currentFloor) {
            isLiftMoving = true;
            new MoveLift().execute(floor);
            isLiftMoving = false;
        }
    }

    private class MoveLift extends AsyncTask<Integer, String, Integer> {

        TextView finalResult = findViewById(R.id.floor_count);
        @Override
        protected Integer doInBackground(Integer... params) {
            SystemClock.sleep(3000);
            currentFloor = (params[0] > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            return params[0];
        }

        @Override
        protected void onPostExecute(Integer result) {

            finalResult.setText(String.valueOf(currentFloor));
            moveNextFloor(result);
            }

    }

}
