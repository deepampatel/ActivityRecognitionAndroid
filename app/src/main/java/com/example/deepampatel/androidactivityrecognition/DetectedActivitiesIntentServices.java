package com.example.deepampatel.androidactivityrecognition;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;

/**
 * Created by Deepam Patel on 6/13/2017.
 */

public class DetectedActivitiesIntentServices extends IntentService {
    protected static final String TAG = "detecion_is";
    public DetectedActivitiesIntentServices(){
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ActivityRecognitionResult result=ActivityRecognitionResult.extractResult(intent);
        Intent localintent=new Intent(Constants.BROADCAST_ACTION);
        ArrayList<DetectedActivity>detectedActivities=(ArrayList) result.getProbableActivities();
        localintent.putExtra(Constants.ACTIVITY_EXTRA,detectedActivities);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localintent);
    }
}
