/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.systemui.tuner;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;

import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.internal.util.fusion.PureFusionUtils;
import com.android.systemui.R;

public class StatusbarIconsFragment extends TunerFragment {

    private static final String TAG = "StatusbarIconsFragment";

    private static final String SHOW_FOURG = "show_fourg";

    private SwitchPreference mShowFourG;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.statusbar_icon_settings);
        final ContentResolver resolver = getActivity().getContentResolver();
        PreferenceScreen prefSet = getPreferenceScreen();

        mShowFourG = (SwitchPreference) findPreference(SHOW_FOURG);
        if (PureFusionUtils.isWifiOnly(getActivity())) {
            prefSet.removePreference(mShowFourG);
        } else {
            mShowFourG.setChecked((Settings.System.getInt(resolver,
                Settings.System.SHOW_FOURG, 0) == 1));
        }
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        if  (preference == mShowFourG) {
            boolean checked = ((SwitchPreference)preference).isChecked();
            Settings.System.putInt(getActivity().getContentResolver(),
                    Settings.System.SHOW_FOURG, checked ? 1:0);
            return true;
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.statusbar_icons_blacklist);
        MetricsLogger.visibility(getContext(), MetricsEvent.TUNER, true);
    }
}
