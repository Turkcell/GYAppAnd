package com.turkcell.gelecegiyazanlar.adapterlistener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activity.BlogIcerikAcitivity;
import com.turkcell.gelecegiyazanlar.model.Icerik;

import java.util.List;

/**
 * Created by asus on 30.9.2015.
 */
public class IcerikAramaAdapter extends BaseAdapter {
    //ImageLoader image= AppController.getInstance().getImageLoader();
    Activity activity;
    private LayoutInflater layoutInflater;
    private List<Icerik> adapterIcerikList;

    public IcerikAramaAdapter(Activity activity, List<Icerik> icerikler) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        adapterIcerikList = icerikler;
        this.activity = activity;

    }


    @Override
    public int getCount() {
        return adapterIcerikList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterIcerikList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

//        if(image==null){
//            image=AppController.getInstance().getImageLoader();
//        }


        final View view = layoutInflater.inflate(R.layout.icerik_arama_satir, parent, false);
        TextView tvbaslik = (TextView) view.findViewById(R.id.tvbaslik);
        TextView tvicerik = (TextView) view.findViewById(R.id.tvicerik);
        //NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.ivsimge);


        final Icerik icerik = adapterIcerikList.get(position);
        tvbaslik.setText(icerik.getTitle());
        tvicerik.setText(Html.fromHtml(icerik.getExcerpt()));
        //imageView.setImageUrl(icerik.getKullaniciAvatarUrl(),image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, BlogIcerikAcitivity.class);
                i.putExtra("blogID", icerik.getNodeID());
                activity.startActivity(i);
            }
        });


        return view;
    }
}