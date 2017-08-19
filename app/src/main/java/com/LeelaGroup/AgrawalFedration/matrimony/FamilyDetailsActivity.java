package com.LeelaGroup.AgrawalFedration.matrimony;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.LeelaGroup.AgrawalFedration.MatrimonySession;
import com.LeelaGroup.AgrawalFedration.Network.ApiClient;
import com.LeelaGroup.AgrawalFedration.R;
import com.LeelaGroup.AgrawalFedration.Service.ServiceMatrimony;
import com.LeelaGroup.AgrawalFedration.matrimony.models.SocialAndFamilyDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetailsActivity extends AppCompatActivity {

    String mat_id;
    ImageView d_person_famildtl_image;
    TextView ftrname, mthrname, mocco, foccu, nob, nos, nobm, nosm, famstat, famtype, famincm;
    MatrimonySession matrimonySession;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_family_details);
        matrimonySession=new MatrimonySession(getApplicationContext());
        init();

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Family Details");

        if(matrimonySession.checkLogin())
            finish();

        mat_id = getIntent().getStringExtra("mat_id");
        getFamilyDetails();

    }

    public void getFamilyDetails() {
        ServiceMatrimony serviceMatrimony = ApiClient.getRetrofit().create(ServiceMatrimony.class);
        Call<SocialAndFamilyDetails> getBasicCall = serviceMatrimony.getfFamilyAndSocialDetails(mat_id);
        getBasicCall.enqueue(new Callback<SocialAndFamilyDetails>() {
            @Override
            public void onResponse(Call<SocialAndFamilyDetails> call, Response<SocialAndFamilyDetails> response) {
                SocialAndFamilyDetails socAndFamDetl = response.body();

                ftrname.setText(socAndFamDetl.getMatRegFatherName());
                mthrname.setText(socAndFamDetl.getMatRegMotherName());
                mocco.setText(socAndFamDetl.getMatRegMotherOccup());
                foccu.setText(socAndFamDetl.getMatRegFatherOccup());
                nob.setText(socAndFamDetl.getMatRegNoBrother());
                nos.setText(socAndFamDetl.getMatRegNoSister());
                nobm.setText(socAndFamDetl.getMatMarBro());
                nosm.setText(socAndFamDetl.getMatMarSis());
                famstat.setText(socAndFamDetl.getMatRegStatus());
                famtype.setText(socAndFamDetl.getMregFamType());
                famincm.setText(socAndFamDetl.getMregFamLpa());

            }

            @Override
            public void onFailure(Call<SocialAndFamilyDetails> call, Throwable t) {

                Toast.makeText(FamilyDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init() {
        //d_person_famildtl_image=(ImageView)findViewById(R.id.d_person_edudetl_image);
        ftrname = (TextView) findViewById(R.id.d_per_fatherfullname);
        mthrname = (TextView) findViewById(R.id.d_per_motherfullname);
        mocco = (TextView) findViewById(R.id.d_per_mtheroccptn);
        foccu = (TextView) findViewById(R.id.d_per_ftheroccptn);
        nob = (TextView) findViewById(R.id.d_per_noofbros);
        nos = (TextView) findViewById(R.id.d_per_sister);
        nobm = (TextView) findViewById(R.id.d_per_noofbrosmaried);
        nosm = (TextView) findViewById(R.id.d_per_noofsismarried);
        famstat = (TextView) findViewById(R.id.d_per_familysatus);
        famtype = (TextView) findViewById(R.id.d_per_familytype);
        famincm = (TextView) findViewById(R.id.d_per_familyanulincome);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:

                onBackPressed();
                finish();

                return  true;
        }

        return super.onOptionsItemSelected(item);
    }

}
