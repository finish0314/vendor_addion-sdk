package com.android.settings.custom.advanced;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;

public class AdvancedSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.advanced_settings);
    }
}
