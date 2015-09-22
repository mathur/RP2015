package edu.illinois.rp2015;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by krishmasand on 9/21/15.
 */
public class RP2015 extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parseAppId), getString(R.string.parseClientKey));
    }
}
