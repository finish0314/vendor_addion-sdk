package com.android.settings.custom.security;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;

public class SecuritySettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.security_settings);
    }
}
