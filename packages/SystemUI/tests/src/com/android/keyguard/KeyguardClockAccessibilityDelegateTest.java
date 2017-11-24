/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.keyguard;

import android.support.test.filters.SmallTest;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;

import com.android.systemui.SysuiTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SmallTest
public class KeyguardClockAccessibilityDelegateTest extends SysuiTestCase {

    private TextView mView;

    @Before
    public void setUp() throws Exception {
        mView = new TextView(mContext);
        mView.setText(R.string.keyguard_widget_12_hours_format);
        mView.setContentDescription(mContext.getString(R.string.keyguard_widget_12_hours_format));
        mView.setAccessibilityDelegate(new KeyguardClockAccessibilityDelegate(mContext));
    }

    @Test
    public void onInitializeAccessibilityEvent_producesNonEmptyAsciiContentDesc() throws Exception {
        AccessibilityEvent ev = AccessibilityEvent.obtain();
        mView.onInitializeAccessibilityEvent(ev);

        assertFalse(TextUtils.isEmpty(ev.getContentDescription()));
        assertTrue(isAscii(ev.getContentDescription()));
    }

    @Test
    public void onPopulateAccessibilityEvent_producesNonEmptyAsciiText() throws Exception {
        AccessibilityEvent ev = AccessibilityEvent.obtain();
        mView.onPopulateAccessibilityEvent(ev);

        assertFalse(isEmpty(ev.getText()));
        assertTrue(isAscii(ev.getText()));
    }

    @Test
    public void onInitializeAccessibilityNodeInfo_producesNonEmptyAsciiText() throws Exception {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
        // Usually done in View.onInitializeAccessibilityNodeInfoInternal, but only when attached.
        info.setContentDescription(mView.getContentDescription());
        mView.onInitializeAccessibilityNodeInfo(info);

        assertFalse(TextUtils.isEmpty(info.getText()));
        assertTrue(isAscii(info.getText()));

        assertFalse(TextUtils.isEmpty(info.getContentDescription()));
        assertTrue(isAscii(info.getContentDescription()));
    }

    private boolean isAscii(CharSequence text) {
        return text.chars().allMatch((i) -> i < 128);
    }

    private boolean isAscii(List<CharSequence> texts) {
        return texts.stream().allMatch(this::isAscii);
    }

    private boolean isEmpty(List<CharSequence> texts) {
        return texts.stream().allMatch(TextUtils::isEmpty);
    }
}