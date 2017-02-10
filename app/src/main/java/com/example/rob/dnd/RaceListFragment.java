package com.example.rob.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by Rob on 2/9/2017.
 */

public class RaceListFragment extends Fragment{

    public void onCreate(View view){

    }

    public void onClickRace(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("raceID", view.getId());
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment race = new CharacterRaceFragment();
        race.setArguments(bundle);
        ft.replace(R.id.characterInfoPlaceHolder, race);
        ft.addToBackStack(null);
        ft.commit();
    }


}
