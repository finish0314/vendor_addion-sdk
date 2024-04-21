package com.android.settings.custom.fuelgauge;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class FuelGaugeSettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "fuelgauge_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new FuelGaugeSettings(), TAG)
                .commit();
    }
}
