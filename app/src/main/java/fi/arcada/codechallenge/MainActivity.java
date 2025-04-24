package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    EditText inputValues, inputWindowSize;
    Button btnCalculate;
    TextView outputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValues = findViewById(R.id.inputValues);
        inputWindowSize = findViewById(R.id.inputWindowSize);
        btnCalculate = findViewById(R.id.btnCalculate);
        outputResult = findViewById(R.id.outputResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSMA();
            }
        });
    }

    private void calculateSMA() {
        try {
            String[] valueStrings = inputValues.getText().toString().split(",");
            double[] values = new double[valueStrings.length];
            for (int i = 0; i < valueStrings.length; i++) {
                values[i] = Double.parseDouble(valueStrings[i].trim());
            }

            int windowSize = Integer.parseInt(inputWindowSize.getText().toString());
            double[] sma = movingAvg.calculateSMA(values, windowSize);

            outputResult.setText("SMA: " + Arrays.toString(sma));
            Log.d("SMA_RESULT", "SMA: " + Arrays.toString(sma));

        } catch (Exception e) {
            outputResult.setText("Fel: Kontrollera att inmatningen är korrekt.");
            Log.e("SMA_ERROR", "Fel vid beräkning", e);
        }
    }

        }


