package com.suhendar.tampanapps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhendar.tampanapps.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuSearch extends Fragment {


    public MenuSearch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_search, container, false);
    }

}
