package fi.arcada.codechallenge;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

TextView myview1;
TextView myview2;
Button calc;

ArrayList<Double> numbers = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myview1 = (TextView)findViewById(R.id.myview1);

        myview1.setText("CodeChallenge2");

        myview2 = (TextView)findViewById(R.id.myview2);

        myview2.setText("Min app fungerar fint");

        calc = (Button)findViewById(R.id.calc);
        calc.setOnClickListener(v -> calculate());

        numbers.add(0.0);
        numbers.add(93.0);
        numbers.add(2.0);
        numbers.add(32.0);
        numbers.add(4.0);
        numbers.add(53.0);
        numbers.add(6.0);
        numbers.add(78.0);
        numbers.add(8.0);
        numbers.add(96.0);
    }

    public void calculate() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        double average = (double)sum / numbers.size();
        myview2.setText("Medeltal: " + average);

    }

}