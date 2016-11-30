package br.com.ericclauberic.na.controle;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by eric on 29/11/16.
 */

public class ServicoEmail extends IntentService {
    public static final String LOG_TAG = "Servico";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServicoEmail(String name) {
        super(name);
    }

    @Override
    public void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
            intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, "ericclauberic@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Erro");
            intent.putExtra(Intent.EXTRA_TEXT," Aconteceu um erro ai mah");
            startActivity(intent);
            Log.d(LOG_TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    Rodando serviço");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
