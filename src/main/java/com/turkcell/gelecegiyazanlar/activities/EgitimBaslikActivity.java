package com.turkcell.gelecegiyazanlar.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.MyExpandableAdapter;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.ActivityEgitimBaslikBinding;
import com.turkcell.gelecegiyazanlar.models.Egitim;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class EgitimBaslikActivity extends AppCompatActivity {

    private ActivityEgitimBaslikBinding activityEgitimBaslikBinding;

    private String baslikString;
    private String renkString;
    private String nodeIDbyKategoriString;
    private Toolbar toolbar;
    private YuklenmeEkran yuklenmeEkran;
    private ArrayList<String> parentItemStringArrayList;
    private ArrayList<Object> childItemObjectArrayList;
    private ArrayList<String> nodeIDGroupStringArrayList;
    private ArrayList<Object> nodeIDChildObjectArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

         activityEgitimBaslikBinding = DataBindingUtil.setContentView(this,R.layout.activity_egitim_baslik);

        Mint.initAndStartSession(EgitimBaslikActivity.this, GYConfiguration.SPLUNK_ID);
        Bundle i = getIntent().getExtras();
        baslikString = i.getString(Egitim.TITLE_TAG);
        renkString = i.getString(Egitim.COLOR_TAG);
        nodeIDbyKategoriString = i.getString(Egitim.NODE_ID);
        toolbar = (Toolbar) findViewById(R.id.toolbarEgitimBaslikActivity);
        toolbar.setTitle(baslikString);
        setSupportActionBar(toolbar);

        ActionbarTasarým();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        parentItemStringArrayList = new ArrayList<String>();
        childItemObjectArrayList = new ArrayList<Object>();
        nodeIDGroupStringArrayList = new ArrayList<String>();
        nodeIDChildObjectArrayList = new ArrayList<Object>();

        toolbar.setNavigationIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.backarrow, null));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        activityEgitimBaslikBinding.expendableListViewListEgitimBaslikActivity.setDividerHeight(2);
        activityEgitimBaslikBinding.expendableListViewListEgitimBaslikActivity.setGroupIndicator(null);

        if (!GYConfiguration.isNetworkAvailable(EgitimBaslikActivity.this)) {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(R.string.internet_baglantinizi_kontrol_edin);

            alertDialogBuilder.setPositiveButton(getString(R.string.buton_tamam_metni), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.dismiss();
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


        setKategori(nodeIDbyKategoriString);

        activityEgitimBaslikBinding.expendableListViewListEgitimBaslikActivity.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Intent i = new Intent(EgitimBaslikActivity.this, EgitimIcerikActivity.class);
                i.putExtra(Egitim.NODE_ID_EGITIM, nodeIDGroupStringArrayList.get(group_pos));
                i.putExtra(Egitim.NODE_TITLE, baslikString);
                startActivity(i);
                return false;
            }
        });


    }

    public void setKategori(final String nodeIDbyKategori) {
        yuklenmeEkran = new YuklenmeEkran(this);
        yuklenmeEkran.surecBasla();

        JsonArrayRequest movieReq = new JsonArrayRequest(Request.Method.GET, GYConfiguration.getDomain() + "egitim_baslik/retrieve?nodeID=" + nodeIDbyKategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONArray belowArray = response.getJSONObject(0).getJSONArray("below");

                    for (int i = 0; i < belowArray.length(); i++) {
                        String anaBaslik = belowArray.getJSONObject(i).getString("title");
                        String node = belowArray.getJSONObject(i).getString("nodeID");

                        parentItemStringArrayList.add(anaBaslik);
                        nodeIDGroupStringArrayList.add(node);

                        JSONArray underBelowArray = belowArray.getJSONObject(i).getJSONArray("below");

                        if (underBelowArray != null) {
                            ArrayList<String> child = new ArrayList<String>();
                            ArrayList<String> childId = new ArrayList<String>();


                            for (int j = 0; j < underBelowArray.length(); j++) {
                                String nodeChild = underBelowArray.getJSONObject(j).getString("nodeID");

                                child.add(underBelowArray.getJSONObject(j).getString("title"));
                                childId.add(nodeChild);
                            }

                            childItemObjectArrayList.add(child);
                            nodeIDChildObjectArrayList.add(childId);

                        }

                    }

                    MyExpandableAdapter adapter = new MyExpandableAdapter(parentItemStringArrayList, childItemObjectArrayList, nodeIDChildObjectArrayList, nodeIDGroupStringArrayList);


                    adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), EgitimBaslikActivity.this);
                    activityEgitimBaslikBinding.expendableListViewListEgitimBaslikActivity.setAdapter(adapter);
                    for (int a = 0; a < adapter.getGroupCount(); a++)
                        activityEgitimBaslikBinding.expendableListViewListEgitimBaslikActivity.expandGroup(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                yuklenmeEkran.surecDurdur();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                yuklenmeEkran.surecDurdur();
                System.out.println(error.getMessage());

            }
        });

        AppController.getInstance().addToRequestQueue(movieReq, "egitimBaslikTag");
    }


    private void ActionbarTasarým() {

        if (renkString.equals("android")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.android_yesil_renk));
        } else if (renkString.equals("ios")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.ios_siyah_renk));
        } else if (renkString.equals("win")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.windows_mavi_renk));
        } else if (renkString.equals("web")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.web_renk));
        } else if (renkString.equals("app")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.app_inventor_kirmizi_renk));
        } else if (renkString.equals("scratch")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.scratch_turuncu_renk));
        } else if (renkString.equals("arduino")) {
            toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.arduino_renk));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppController.getInstance().cancelPendingRequests("egitimBaslikTag");
    }
}
