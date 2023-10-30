package kemboi.tech.uipart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox checkboxwebdev,checkboxcyber,checkboxMobile;
    private RadioGroup maritalStatus;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        checkbox
        checkboxcyber = findViewById(R.id.checkboxcyber);
        checkboxcyber.setOnCheckedChangeListener(this);
        checkboxwebdev = findViewById(R.id.checkboxwebdev);
        checkboxwebdev.setOnCheckedChangeListener(this);
        checkboxMobile = findViewById(R.id.checkboxMobile);
        checkboxMobile.setOnCheckedChangeListener(this);

//        checkbox
        maritalStatus = findViewById(R.id.maritalStatus);
        progressBar = findViewById(R.id.progressBar);

//        progressbar thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(1000);
                }
            }
        });
        thread.start();

//        System.out.println(progressBar.getProgress());

        maritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

//            Methods for Radio buttons
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioMarried){
                    Toast.makeText(MainActivity.this, "You married 😀", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioSingle) {
                    Toast.makeText(MainActivity.this, "Look for Mpoa 😅", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioRel) {
                    Toast.makeText(MainActivity.this, "Congraulations 🥰", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

//    Methods for checkboxes
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton == checkboxcyber) {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "cyber Security checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "cyber Security unchecked", Toast.LENGTH_SHORT).show();
            }
        }

        if (compoundButton == checkboxwebdev) {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "web development checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "web development unchecked", Toast.LENGTH_SHORT).show();
            }
        }

        if (compoundButton == checkboxMobile) {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "mobile dev checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "mobile dev unchecked", Toast.LENGTH_SHORT).show();
            }
        }
    }

}