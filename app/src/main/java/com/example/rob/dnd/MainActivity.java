package com.example.rob.dnd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Spinner raceSpinner = (Spinner) findViewById(R.id.race_spinner);
        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this,R.array.race_array, android.R.layout.simple_spinner_item);
        raceSpinner.setAdapter(raceAdapter);
        */
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.abilityScorePlaceHolder, new abilityScoreFragment());
        ft.replace(R.id.characterInfoPlaceHolder, new CharacterInfoFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    /*public void onClickRollD20(View view){
        final Random rand = new Random();
        final Button rollIt = (Button)findViewById(R.id.roll_button);
        final TextView rollResult = (TextView) findViewById(R.id.roll_result);
        rollIt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String resultD20 = String.valueOf(rand.nextInt(20) + 1);
                rollResult.setText(resultD20);
            }
        });
    }
    */
    public void onClickRollD20(View view) {
        Button gotoRace = (Button) findViewById(R.id.characterRaceEdit);
        gotoRace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //onClickRace(view);
            }
        });
    }



    public void changeStrength(View view){
        final EditText strength = (EditText) findViewById(R.id.strength_score);
        final int str = Integer.valueOf(strength.getText().toString());
        final TextView str_mod = (TextView) findViewById(R.id.strength_modifier);
        strength.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                str_mod.setText((str/2)-5);


            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
