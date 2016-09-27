package br.com.ericclauberic.na.controle;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by eric on 09/09/16.
 */
public class ToastListener extends AdListener {

    private String mErrorReason;
    private Context mContext;

    public ToastListener(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onAdOpened() {
      //  Toast.makeText(mContext, "onAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
      //  Toast.makeText(mContext, "onAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();

      //  Toast.makeText(mContext, "onAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        super.onAdFailedToLoad(errorCode);

        mErrorReason = "";

        switch (errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                mErrorReason = "Erro interno";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                mErrorReason = "Requisição inválida";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                mErrorReason = "Erro na rede";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                mErrorReason = "No FILL";
                break;
        }
     //   Toast.makeText(mContext, mErrorReason, Toast.LENGTH_SHORT).show();
    }


    public String getErrorReason() {
        return mErrorReason == null ? "" : mErrorReason;
    }




    @Override
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
    }

}
