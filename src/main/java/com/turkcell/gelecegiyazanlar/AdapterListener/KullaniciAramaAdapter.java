package com.turkcell.gelecegiyazanlar.AdapterListener;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.turkcell.gelecegiyazanlar.Configuration.AppController;
import com.turkcell.gelecegiyazanlar.Model.Kisi;
import com.turkcell.gelecegiyazanlar.R;

import java.util.List;

/**
 * Created by asus on 17.9.2015.
 */
public class KullaniciAramaAdapter  extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Kisi> adapterKisiList;
    ImageLoader image= AppController.getInstance().getImageLoader();

    public KullaniciAramaAdapter(Activity activity, List<Kisi> kisiler){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        adapterKisiList = kisiler;

    }


    @Override
    public int getCount() {
        return adapterKisiList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterKisiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(image==null){
            image=AppController.getInstance().getImageLoader();
        }


        View view = layoutInflater.inflate(R.layout.arama_satir_layout,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.tvisimsoyisim);
        TextView kullanici = (TextView) view.findViewById(R.id.tvkullanici);
        NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.ivsimge);


        Kisi kisi = adapterKisiList.get(position);
        textView.setText( kisi.getAdSoyad());
                kullanici.setText(kisi.getKullaniciAdi());
         imageView.setImageUrl(kisi.getKullaniciAvatarUrl(),image);


        return view;
    }
}
