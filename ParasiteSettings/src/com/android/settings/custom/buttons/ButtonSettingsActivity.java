package com.android.settings.custom.buttons;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class ButtonSettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "button_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new ButtonSettings(), TAG)
                .commit();
    }
}
