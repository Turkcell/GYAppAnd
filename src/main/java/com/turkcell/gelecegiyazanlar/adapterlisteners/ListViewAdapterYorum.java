package com.turkcell.gelecegiyazanlar.adapterlisteners;

/**
 * Created by macbook on 9/9/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.ProfilActivity;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.models.Yorum;

import java.util.List;

/**
 * Created by macbook on 9/9/15.
 */
public class ListViewAdapterYorum extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Yorum> mYorumListesi;


    public ListViewAdapterYorum(Activity activity, List<Yorum> yorumlar) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mYorumListesi = yorumlar;
    }

    @Override
    public int getCount() {
        return mYorumListesi.size();
    }

    @Override
    public Yorum getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mYorumListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.layout.yorum_satir_tasarim, null);
        TextView textView =
                (TextView) satirView.findViewById(R.id.isimsoyisim);
        ImageView imageView =
                (ImageView) satirView.findViewById(R.id.simge);


        TextView yorum =
                (TextView) satirView.findViewById(R.id.yorum);

        TextView tarih =
                (TextView) satirView.findViewById(R.id.tarih);

        final Yorum kisi = mYorumListesi.get(position);


        textView.setText(kisi.getAdsoyad());
        yorum.setText(Html.fromHtml(kisi.getYorum()));
        tarih.setText(kisi.getTarih());
        imageView.setImageDrawable(satirView.getResources().getDrawable(R.drawable.resim_default));
        ResimGoruntule(String.valueOf(kisi.getFoto()), imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ProfilActivity.class);
                i.putExtra("id", kisi.getId());
                v.getContext().startActivity(i);
            }
        });


        return satirView;
    }

    public void ResimGoruntule(String resimURL, final ImageView image) {

        ImageRequest im = new ImageRequest(resimURL, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                image.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(im);
    }
}