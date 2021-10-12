package org.microg.nlp.app;

import android.content.Intent;
import android.os.IBinder;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ServiceTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.microg.nlp.service.UnifiedLocationService;
import org.microg.nlp.service.UnifiedLocationServiceEntryPoint;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UnifiedLocationServiceTest {

    @Rule
    public final ServiceTestRule serviceRule = new ServiceTestRule();

    @Test
    public void testWithBoundService() throws Exception {
        Intent serviceIntent = new Intent();
        String serviceName = UnifiedLocationServiceEntryPoint.class.getCanonicalName();
        serviceIntent.setClassName(BuildConfig.APPLICATION_ID, serviceName);
        IBinder binder = serviceRule.bindService(serviceIntent);
        assertNotNull(binder);
        serviceRule.startService(serviceIntent);
        UnifiedLocationService service = UnifiedLocationService.Stub.asInterface(binder);
        String[] backends = service.getLocationBackends();
        assertThat(backends, Matchers.notNullValue());
    }
}

