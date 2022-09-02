package com.drifter.nfc;

import android.util.Log;

public class ReadCardByNFC {
    private NfcResultCallback nfcResultCallbackImpl;
    private static ReadCardByNFC nfcProcessor = null;
    public String cardInformation="NotRead";

    public static ReadCardByNFC getInstance()
    {
        if (nfcProcessor == null)
            nfcProcessor = new ReadCardByNFC();

        return nfcProcessor;
    }
    public NfcResultCallback getNfcResultCallbackImpl() {
        return nfcResultCallbackImpl;
    }

    public void setNfcResultCallbackImpl(NfcResultCallback nfcResultCallbackImpl) {
        this.nfcResultCallbackImpl = nfcResultCallbackImpl;
    }

    public void requestUpdates(NfcResultCallback nfcResultCallback, String readStatus)
    {
        nfcResultCallback.onStatusChanged(readStatus);
        setNfcResultCallbackImpl(nfcResultCallback);
    }
    public String getCardInf()
 {
    return this.cardInformation;

 }

}
