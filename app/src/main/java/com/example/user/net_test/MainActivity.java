package com.example.user.net_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int x, y;

        Network.helloApi.getHelloMessage()
                .observeOn(AndroidSchedulers.mainThread())
                .delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<HelloMessage>() {
                    @Override
                    public void accept(HelloMessage helloMessage) throws Exception {
                        ((TextView) findViewById(R.id.textView)).setText(helloMessage.message);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("error", throwable.getMessage(), throwable);
                    }
                });
    }
}
