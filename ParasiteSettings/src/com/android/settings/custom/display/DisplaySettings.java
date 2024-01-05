package com.android.settings.custom.display;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;

public class DisplaySettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.display_settings);
    }
}
