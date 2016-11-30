package br.com.ericclauberic.na;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.ericclauberic.na.controle.ServicoEmail;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


    }

    public void onClickEnviarEmail(View view) {

        enviarEmail();

    }

    public void enviarEmail() {

        ServicoEmail servicoEmail = new ServicoEmail("Serviço");

        Intent email = new Intent(/*Intent.ACTION_SENDTO*/);
//        email.setData(Uri.parse("mailto:"));
//        email.putExtra(Intent.EXTRA_EMAIL, "ericclauberic@gmail.com");
//        email.putExtra(Intent.EXTRA_SUBJECT, "Erro");
//        email.putExtra(Intent.EXTRA_TEXT, " Aconteceu um erro ai mah");

        servicoEmail.onHandleIntent(email);

    }

    ;
}
