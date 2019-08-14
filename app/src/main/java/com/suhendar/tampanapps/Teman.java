package com.suhendar.tampanapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Teman extends AppCompatActivity implements View.OnClickListener {
    Button btnSimpan, btnTampil, btn_kembali;
    EditText nim, nama;
    String sNama;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman);

        //Inisialisasi
        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        btn_kembali = findViewById(R.id.btnCancel);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);

        //Set up Realm
        Realm.init(Teman.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btn_kembali.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();

            if (!sNim.equals("") && !sNama.isEmpty()){
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(Teman.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
            }else {
                Toast.makeText(Teman.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            startActivity(new Intent(Teman.this, MahasiswaActivity.class));
        }else if (v == btn_kembali) {
            startActivity(new Intent(Teman.this, Menu.class));
            finish();
        }
    }
}