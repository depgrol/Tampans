package com.suhendar.tampanapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MahasiswaActivity extends AppCompatActivity implements View.OnClickListener{
    Realm realm;
    Button btn_kembali;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    MahasiswaAdapter mahasiswaAdapter;
    List<MahasiswaModel> mahasiswaModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        btn_kembali = findViewById(R.id.btnCancel);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        mahasiswaModels = new ArrayList<>();

        mahasiswaModels = realmHelper.getAllMahasiswa();
        btn_kembali.setOnClickListener(this);
        show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mahasiswaAdapter.notifyDataSetChanged();
        show();
    }

    public void show(){
        mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaModels);
        recyclerView.setAdapter(mahasiswaAdapter);
    }
    @Override
    public void onClick(View v) {
        if (v == btn_kembali) {
            startActivity(new Intent(MahasiswaActivity.this, Teman.class));
            finish();
        }
    }
}