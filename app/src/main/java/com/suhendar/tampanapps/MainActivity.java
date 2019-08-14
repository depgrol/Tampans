package com.suhendar.tampanapps;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private Button button;
    private int[] layouts = {R.layout.fragment_halaman_satu, R.layout.fragment_halaman_dua, R.layout.fragment_halaman_tiga};
    private Adaptor mpagerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager = (ViewPager) findViewById(R.id.viewPager);
        mpagerAdaptor = new Adaptor(layouts, this);
        pager.setAdapter(mpagerAdaptor);


    }

    public void next(View view) {
        Intent in = new Intent(this, LoginActivity.class);
        startActivity(in);

    }
}