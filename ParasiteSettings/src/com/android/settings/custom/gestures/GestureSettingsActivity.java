package com.android.settings.custom.gesture;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class GestureSettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "gesture_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new GestureSettings(), TAG)
                .commit();
    }
}
