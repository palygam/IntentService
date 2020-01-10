package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;

import java.util.Arrays;
import java.util.Random;

public class MyIntentService extends IntentService {
    private int[] array;
    public static final String ACTION_INTENT_SERVICE = "com.example.intentservice";
    public static final String KEY = "KEY";


    public MyIntentService() {
        super("SortArrayService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sortArray();
        Intent responseIntent = new Intent();
        responseIntent.setAction(ACTION_INTENT_SERVICE);
        responseIntent.putExtra(KEY, Arrays.toString(array));
        sendBroadcast(responseIntent);
    }


    public int[] sortArray() {
        array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        Arrays.sort(array);
        return array;
    }
}