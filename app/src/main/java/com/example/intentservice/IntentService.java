package com.example.intentservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class IntentService extends android.app.IntentService {

    public IntentService() {
        super("SortArrayService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sortArray();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Array sorted",Toast.LENGTH_SHORT).show();
    }

    public void sortArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        Arrays.sort(array);
    }
}