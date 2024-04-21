package com.android.settings.custom.fuelgauge;

import android.os.Bundle;

import android.content.Context;

import com.android.settings.custom.R;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceCategory;

public class FuelGaugeSettings extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.fuelgauge_settings);
    }
}
