package com.acme.plugin.airplane;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.DialogInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Airplane extends CordovaPlugin {
    protected void pluginInitialize() {
    }
    
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
    throws JSONException {
        if (action.equals("airplane")) {
            airplane(callbackContext);
            return true;
        }
        return false;
    }
    
    private synchronized void airplane( final CallbackContext callbackContext) {
        
        // check current state first
        boolean state = isAirplaneMode();
        // toggle the state
        toggleAirplaneMode(state);
        ser = new ServiceState();
        ser.setState(STATE_IN_SERVICE);
        
    }
}