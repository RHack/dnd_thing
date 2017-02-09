package com.example.rob.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Rob on 2/5/2017.
 */

public class CharacterRaceFragment extends Fragment implements OnItemSelectedListener {
    Spinner raceSpinner;
    ArrayAdapter<CharSequence> adapter;
    Button raceButton;
    TextView raceTextView;
    String characterRace;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.character_race_fragment, parent, false);
        raceSpinner = (Spinner) view.findViewById(R.id.race_spinner);
        raceButton = (Button) view.findViewById(R.id.characterRaceEdit);
        raceTextView = (TextView) view.findViewById(R.id.characterRaceText);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.race_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        raceSpinner.setAdapter(adapter);
        raceSpinner.setOnItemSelectedListener(parent);
        // Defines the xml file for the fragment
        return view;
    }

    @Override
    public void setOnItemSelectedListener(){

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        characterRace = parent.getItemAtPosition(position).toString();
        raceSpinner.setSelection(position);
        String viewVdc = (String) raceSpinner.getSelectedItem();
        raceButton.setText(characterRace);
        raceTextView.setText(characterRace);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}