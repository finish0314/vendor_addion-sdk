package com.android.settings.custom.sound;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;

public class SoundSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.sound_settings);
    }
}
