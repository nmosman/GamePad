package com.example.nasir.droidmote;

import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.ArrayList;
import java.util.UUID;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Created by Nasir on 2016-05-08.
 */
public class dialogActivity extends Activity {
    private  BluetoothAdapter mBluetoothAdapter;

    UUID MY_UUID = UUID.fromString("dda07d60-1484-11e6-a837-0800200c9a66");
    String TAG = "dialogActivity";
    boolean D = false;
    private OutputStream outputStream;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


    }
    @Override
    protected void onCreate(Bundle bundle)
    {

        super.onCreate(bundle);
        setContentView(R.layout.main_menu);

        String dvAddr = getIntent().getExtras().getString("device_address");

        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText(dvAddr);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(dvAddr);
        BluetoothSocket tmp = null;
        BluetoothSocket mSocket = null;


        try{
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            Method m = device.getClass().getMethod("createRfcommSocket", new Class[] {int.class});
            tmp = (BluetoothSocket) m.invoke(device,1);
        }

        catch(IOException e )
        {

            Log.e(TAG, "sigma35blehconnection failed!", e);
        }

        catch(NoSuchMethodException e)
        {
            Log.e(TAG, "sigma35Error with method", e);
        }

        catch(Exception e)
        {
            Log.e(TAG, "sigma35Error:", e);
        }

        mSocket = tmp;

        try
        {
            mSocket.connect();

            if(D)
                Log.d(TAG, "sigma35isConnected: " + mSocket.isConnected());

            mSocket.close();
        }
        catch(IOException e)
        {
            Log.e(TAG, "sigma35error closing socket", e);
        }
    }
}
