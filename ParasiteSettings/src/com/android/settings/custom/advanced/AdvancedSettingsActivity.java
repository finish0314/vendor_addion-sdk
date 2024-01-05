package com.android.settings.custom.advanced;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.widget.R;

public class AdvancedSettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "advanced_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new AdvancedSettings(), TAG)
                .commit();
    }
}
