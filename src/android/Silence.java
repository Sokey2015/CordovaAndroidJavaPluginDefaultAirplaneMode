package com.acme.plugin.silence;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Silence extends CordovaPlugin {
    protected void pluginInitialize() {
    }
    
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
    throws JSONException {
        if (action.equals("toggleAirplane")) {
            toggleAirplane(callbackContext);
            return true;
        } else if (action.equals("toggleRinger")) {
            toggleRinger(callbackContext);
            return true;
        }
        else if (action.equals("toggleNotifications")) {
            toggleNotifications(callbackContext);
            return true;
        }
        return false;
    }
    
    //toggle airplane mode (if on, turn off, if off, turn on)
    private synchronized void toggleAirplane( final CallbackContext callbackContext) {
        
        // check current state first
        boolean state = isAirplaneMode();
        // toggle the state
        toggleAirplaneMode(state);
        ser = new ServiceState();
        ser.setState(STATE_IN_SERVICE);
        
    }
    
    //toggle ringer (if on, turn off, if off, turn on)
    private synchronized void toggleRinger( final CallbackContext callbackContext) {
        
        private AudioManager mAudioManager;
        private boolean mPhoneIsSilent;
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            super.onCreate(savedInstanceState);
            mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
            checkIfPhoneIsSilent();
            setButtonClickListener();
            Log.d("SilentModeApp", "This is a test");
        }
        
        private void setButtonClickListener() {
            Button toggleButton = (Button)findViewById(R.id.silent);
            toggleButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (mPhoneIsSilent) {
                        //change back to normal mode
                        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        mPhoneIsSilent = false;
                    }
                    else
                    {
                        //change to silent mode
                        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        mPhoneIsSilent = true;
                    }
                    // Now toggle the UI again
                    toggleUi();
                }
            });
        }
        
        private void checkIfPhoneIsSilent() {
            int ringermode = mAudioManager.getRingerMode();
            if (ringermode == AudioManager.RINGER_MODE_SILENT) {
                mPhoneIsSilent = true;
            }
            else
            {
                mPhoneIsSilent = false;
            }
        }
        
        private void toggleUi() {
            ImageView imageView = (ImageView) findViewById(R.id.phone_icon);
            Drawable newPhoneImage;
            if (mPhoneIsSilent){
                newPhoneImage =
                getResources().getDrawable(R.drawable.phone_silent);
            }
            else
            {
                newPhoneImage =
                getResources().getDrawable(R.drawable.phone_on);
                
            }
            imageView.setImageDrawable(newPhoneImage);
        }
        
        @Override      
        protected void onResume() {
            super.onResume();
            checkIfPhoneIsSilent();
            toggleUi();
        }
    }
    

    //toggle notifications (if on, turn off, if off, turn on)
    private synchronized void toggleNotifications( final CallbackContext callbackContext) {
        
  
        
    }
}