package com.android.settings.custom.display;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.widget.R;

public class DisplaySettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "display_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new DisplaySettings(), TAG)
                .commit();
    }
}
