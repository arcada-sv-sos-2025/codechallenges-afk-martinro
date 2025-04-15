package fi.arcada.codechallenge;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.EditText;


public class SettingsActivity extends AppCompatActivity {
    private Button resetButton;
    private SharedPreferences sharedPreferences;

    // Återanvänd koden i MainActivity, så vi använder samma sharedPreference fil och "räknare"
    private static final String PREFS_NAME = "AppCounterPrefs";
    private static final String APP_COUNTER_KEY = "appCounter";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        // Helt vanlig knapp som vi hittar
        // På knappen sätter vi funktionen att nolla vår räknare
        // - Samma sätt som vi uppdatera den, kan vi sätta den till noll
        // --- Man kan göra om denna knapp till Spara knappen!
        EditText usrInput = findViewById(R.id.usrInput);
        resetButton = findViewById(R.id.sparaKnapp);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        resetButton.setOnClickListener(v -> {
            String userInput = usrInput.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("UserInput", userInput);
            editor.apply();
            finish();
        });
    }
}
