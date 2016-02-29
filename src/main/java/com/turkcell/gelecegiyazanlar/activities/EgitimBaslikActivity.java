package com.turkcell.gelecegiyazanlar.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class EgitimBaslikActivity extends ActionBarActivity {

    String baslik;
    String renk;
    String nodeIDbyKategori;
    ProgressDialog pDialog;
    Toolbar toolbar;
    ExpandableListView expandableList;
    YuklenmeEkran yuklenmeEkran;
    private ArrayList<String> parentItems;
    private ArrayList<Object> childItems;
    private ArrayList<String> nodeIDGroup;
    private ArrayList<Object> nodeIDChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egitim_baslik);
        Mint.initAndStartSession(EgitimBaslikActivity.this, GYConfiguration.SPLUNK_ID);
        Bundle i = getIntent().getExtras();
        baslik = i.getString("title");
        renk = i.getString("color");
        nodeIDbyKategori = i.getString("nodeID");
        toolbar = (Toolbar) findViewById(R.id.tool_bar2);
        toolbar.setTitle(baslik);
        setSupportActionBar(toolbar);

        ActionbarTasarým();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        parentItems = new ArrayList<String>();
        childItems = new ArrayList<Object>();
        nodeIDGroup = new ArrayList<String>();
        nodeIDChild = new ArrayList<Object>();

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backarrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        expandableList = (ExpandableListView) findViewById(R.id.list);

        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);

        if (!GYConfiguration.isNetworkAvailable(EgitimBaslikActivity.this)) {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Lütfen Internet Baðlantýnýzý Kontrol Ediniz.");

            alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.dismiss();
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


        setKategori(nodeIDbyKategori);

        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Intent i = new Intent(EgitimBaslikActivity.this, EgitimIcerikActivity.class);
                i.putExtra("nodeIDEgitim", nodeIDGroup.get(group_pos));
                i.putExtra("nodeTitle", baslik);
                startActivity(i);
                return false;
            }
        });


    }

    public void setKategori(final String nodeIDbyKategori) {
        yuklenmeEkran = new YuklenmeEkran(this);
        yuklenmeEkran.surecBasla();
        Log.d("xx", GYConfiguration.getDomain() + "egitim_baslik/retrieve?nodeID=" + nodeIDbyKategori);

        JsonArrayRequest movieReq = new JsonArrayRequest(Request.Method.GET, GYConfiguration.getDomain() + "egitim_baslik/retrieve?nodeID=" + nodeIDbyKategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("json:", GYConfiguration.getDomain() + "egitim_baslik/retrieve?nodeID=" + nodeIDbyKategori);


                try {
                    JSONArray belowArray = response.getJSONObject(0).getJSONArray("below");

                    for (int i = 0; i < belowArray.length(); i++) {
                        String anaBaslik = belowArray.getJSONObject(i).getString("title");
                        String node = belowArray.getJSONObject(i).getString("nodeID");
                        Log.d("title:", anaBaslik + "\n");
                        parentItems.add(anaBaslik);
                        nodeIDGroup.add(node);

                        JSONArray underBelowArray = belowArray.getJSONObject(i).getJSONArray("below");
                        Log.d("size:", String.valueOf(underBelowArray.length()));
                        if (underBelowArray != null) {
                            ArrayList<String> child = new ArrayList<String>();
                            ArrayList<String> childId = new ArrayList<String>();


                            for (int j = 0; j < underBelowArray.length(); j++) {
                                String nodeChild = underBelowArray.getJSONObject(j).getString("nodeID");
                                Log.d("childTitle:", underBelowArray.getJSONObject(j).getString("title") + " " + nodeChild + "\n");
                                child.add(underBelowArray.getJSONObject(j).getString("title"));
                                childId.add(nodeChild);
                            }

                            childItems.add(child);
                            nodeIDChild.add(childId);

                        }

                    }

                    MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems, nodeIDChild, nodeIDGroup);


                    adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), EgitimBaslikActivity.this);
                    expandableList.setAdapter(adapter);
                    for (int a = 0; a < adapter.getGroupCount(); a++)
                        expandableList.expandGroup(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                yuklenmeEkran.surecDurdur();
                Log.d("size parent:", String.valueOf(parentItems.size()));
                Log.d("size parent:", String.valueOf(childItems.size()));

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

        if (renk.equals("android")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.android_yesil_renk));
        } else if (renk.equals("ios")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.ios_siyah_renk));
        } else if (renk.equals("win")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.windows_mavi_renk));
        } else if (renk.equals("web")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.web_renk));
        } else if (renk.equals("app")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.app_inventor_kirmizi_renk));
        } else if (renk.equals("scratch")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.scratch_turuncu_renk));
        } else if (renk.equals("arduino")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.arduino_renk));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppController.getInstance().cancelPendingRequests("egitimBaslikTag");
    }
}
