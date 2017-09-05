package com.android.settings.custom.sound;

import android.os.Bundle;

import android.content.Context;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceCategory;

import android.telephony.TelephonyManager;

public class SoundSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.sound_settings);

        final PreferenceCategory incallVibrationCategory =
                (PreferenceCategory) getPreferenceScreen().findPreference("accessibility_incall_vibration_category");

        if (!isVoiceCapable()) {
            getPreferenceScreen().removePreference(incallVibrationCategory);
        }
    }

    private boolean isVoiceCapable() {
        TelephonyManager telephony =
                (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return telephony != null && telephony.isVoiceCapable();
    }
}
