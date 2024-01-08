package com.android.settings.custom.network;

import android.os.Bundle;

import android.content.Context;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceCategory;

public class NetworkSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.network_settings);

    }
}
