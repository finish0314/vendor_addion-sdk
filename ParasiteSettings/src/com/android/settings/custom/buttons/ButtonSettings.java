package com.android.settings.custom.buttons;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;

public class ButtonSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.button_settings);
    }
}
