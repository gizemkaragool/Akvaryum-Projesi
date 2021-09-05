package com.nexis.akvaryum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpCookie;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtKullanici,textBilgi,textYem;
    private Button btnYemle,btnSicaklikArt,btnSicaklikAz,btnBilgi;
    private String gelenkAdi;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference oku = FirebaseDatabase.getInstance().getReference().child("Durum").child("durum2");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textBilgi = (TextView)findViewById(R.id.txtBilgi);
        textYem = (TextView)findViewById(R.id.txtYem);
        txtKullanici = (TextView)findViewById(R.id.textKullanici);
        btnYemle = (Button)findViewById(R.id.buttonYem);
        btnSicaklikAz = (Button)findViewById(R.id.buttonSicaklikAz);
        btnSicaklikArt = (Button)findViewById(R.id.buttonSicaklikArt);
        btnSicaklikArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textYem.setText("Sıcaklık 0.2 derece arttırıldı!");
            }
        });
        btnSicaklikAz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textYem.setText("Sıcaklık 0.2 derece azaltıldı !");
            }
        });
        btnYemle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textYem.setText("Balıklarınız Yemlendi !");
            }
        });
        btnBilgi = (Button)findViewById(R.id.butonBilgi);
        btnBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueEventListener dinle = new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Durumlar newDurum = new Durumlar();

                        newDurum = snapshot.getValue(Durumlar.class);
                        textBilgi.setText("Sıcaklık : "+newDurum.sicaklik+" Nem : "+newDurum.nem);

                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                oku.addValueEventListener(dinle);
            }
        });





        Intent gelenIntent = getIntent();
        gelenkAdi = gelenIntent.getStringExtra("editTxtKullanici");
        txtKullanici.setText(gelenkAdi);
    }



    @Override
    public void onBackPressed(){
        Intent backIntent = new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(backIntent);
    }
}