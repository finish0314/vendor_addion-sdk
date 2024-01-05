package com.android.settings.custom.sound;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.widget.R;

public class SoundSettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "sound_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new SoundSettings(), TAG)
                .commit();
    }
}
