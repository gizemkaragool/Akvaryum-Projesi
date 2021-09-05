package com.nexis.akvaryum;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtKullanici;
    private EditText editTxtParola;
    private TextView txtViewUyari;
    private String editKullanici, editParola;
    private String dogrukAdi = "gzmkaragolll", dogrukSifre = "balıknemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtKullanici = (EditText)findViewById(R.id.editTextPersonName);
        editTxtParola = (EditText)findViewById(R.id.editTextTextPassword);
        txtViewUyari = (TextView)findViewById(R.id.textViewUyari);
    }

   


    public void btnGiris(View v) {
        editKullanici = editTxtKullanici.getText().toString();
        editParola = editTxtParola.getText().toString();

        if (!TextUtils.isEmpty(editKullanici)) {
            if (!TextUtils.isEmpty(editParola)) {
                if (dogrukAdi.equals(editKullanici)) {
                    if (dogrukSifre.equals(editParola)) {

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("editTxtKullanici",dogrukAdi);
                        finish();
                        startActivity(intent);
                    } else
                        txtViewUyari.setText("Şifrenizi yanlış girdiniz !");
                } else
                    txtViewUyari.setError("Kullanıcı adınızı yanlış girdiniz !");
            } else
                txtViewUyari.setText("Şifrenizi boş giremezsiniz !");
        } else
            txtViewUyari.setText("Kullanıcı adınızı boş giremezsiniz !");

    }
}