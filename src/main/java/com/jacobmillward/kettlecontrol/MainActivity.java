package com.jacobmillward.kettlecontrol;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jacobmillward.libkettlecontrol.Kettle;
import com.jacobmillward.libkettlecontrol.KettleCallback;
import com.jacobmillward.libkettlecontrol.KettleCommand;

import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements KettleCallback {

    Button Button_power;
    Button Button_warm;
    Button Button_65;
    Button Button_80;
    Button Button_95;
    Button Button_100;

    Kettle kettle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_power = (Button)findViewById(R.id.button_power);
        Button_warm = (Button)findViewById(R.id.button_warm);
        Button_65 = (Button)findViewById(R.id.button_65);
        Button_80 = (Button)findViewById(R.id.button_80);
        Button_95 = (Button)findViewById(R.id.button_95);
        Button_100 = (Button)findViewById(R.id.button_100);
        kettle = new Kettle(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ButtonOnClick(View view) {
        if (view == Button_power) {
            kettle.sendCommand(KettleCommand.BTN_ON);
        }
        else if (view == Button_warm) {
            kettle.sendCommand(KettleCommand.BTN_WARM);
        }
        else if (view == Button_65) {
            kettle.sendCommand(KettleCommand.BTN_65C);
        }
        else if (view == Button_80) {
            kettle.sendCommand(KettleCommand.BTN_80C);
        }
        else if (view == Button_95) {
            kettle.sendCommand(KettleCommand.BTN_95C);
        }
        else if (view == Button_100) {
            kettle.sendCommand(KettleCommand.BTN_100C);
        }
    }

    @Override
    public void onConnectionComplete() {
        final Context context = this;
        if (kettle.isConnected()) {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Connected to " + kettle.getHostname(), Toast.LENGTH_LONG).show();
                }
            });

        }
        else {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Connected to " + kettle.getHostname(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
