package com.baoxuan.multipane;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();

        //supply index input as an argument
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    @TargetApi(26)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // We have different layout, and in one of them this fragment's containing frame doesn't exist
        // The fragment may still be created from its saved state, but there is no reason
        // to try to create its view hierarchy because it isn't displayed.
        // Note this isn't needed -- we could just run the code below, where we could
        // create and return view hierarchy; it would just never be used.
        if (container == null) {
            return null;
        }

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        text.setText(Shakespeare.DIALOGUE[getShownIndex()]);
        text.setTextSize(16);
        text.setTextColor(getResources().getColor(R.color.textDarkRed));
        text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
//        scroller.getRootView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
        return scroller;
    }
}