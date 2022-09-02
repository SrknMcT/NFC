package com.drifter.nfc;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.nfctest.MainActivity;

@CapacitorPlugin(name = "ReadCardByNFC")
public class ReadCardByNFCPlugin extends Plugin {

    ReadCardByNFC nfcProcessor;

   public void load()
   {
       nfcProcessor=ReadCardByNFC.getInstance();
   }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void readCard(PluginCall call) {
        call.setKeepAlive(true);

        Context mContext = getContext();
        Intent myIntent = new Intent(mContext, MainActivity.class);
        startActivityForResult(call, myIntent, "echoResult");
        sendCardInformation(call,"NotRead");
    }

    @ActivityCallback
    private void echoResult(PluginCall call, ActivityResult result) {

        if (call == null) {
            return;
        }

        Log.i("code", String.valueOf(result.getResultCode()));


    }


    private void sendCardInformation(final PluginCall call, String readStatus)
    {
        nfcProcessor.requestUpdates(   new NfcResultCallback() {
            @Override
            public void onStatusChanged(String readStatus) {
                JSObject ret = new JSObject();
                ret.put("cardstatus", readStatus);
                call.resolve(ret);
            }
        },readStatus);

    }
}
