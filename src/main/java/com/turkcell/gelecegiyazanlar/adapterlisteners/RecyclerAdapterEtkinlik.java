package com.turkcell.gelecegiyazanlar.adapterlisteners;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.EtkinlikIcerikActivity;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.models.Etkinlik;

import java.util.List;

/**
 * Created by dyildirim76 on 09.09.2015.
 */
public class RecyclerAdapterEtkinlik extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity activity;
    private List<Etkinlik> mItemList;


    public RecyclerAdapterEtkinlik(List<Etkinlik> mItemList, Activity activity) {


        this.mItemList = mItemList;
        this.activity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_item_etkinlik, parent, false);


        return RecyclerItemViewHolder.newInstance(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        Etkinlik etkinlik = mItemList.get(position);
        String titleText = etkinlik.getTitle();
        String startDateTextView = etkinlik.getStartDate();
        String endDateTextView = etkinlik.getEndDate();
        String thumbnail = etkinlik.getImage();
        String id = etkinlik.getNodeID();
        String days = etkinlik.getKalanGun();

        holder.setItemText(titleText, startDateTextView, endDateTextView, id, days);
        holder.setmImageView(thumbnail);


    }


    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mTitleTextView;
        private final TextView mStartDateTextView;
        private final TextView mEndDateTextView;
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        private NetworkImageView mImageView;
        private TextView profilid;
        private TextView days;
        private LinearLayout layout;

        public RecyclerItemViewHolder(final View parent, TextView titleTextView,
                                      TextView mStartDateTextView, TextView mEndDateTextView,
                                      NetworkImageView mImageView, TextView id, TextView gun, LinearLayout layout_gun) {

            super(parent);
            parent.setClickable(true);
            parent.setOnClickListener(this);
            mTitleTextView = titleTextView;
            this.mStartDateTextView = mStartDateTextView;
            this.mEndDateTextView = mEndDateTextView;
            this.mImageView = mImageView;
            this.profilid = id;
            this.days = gun;
            this.layout = layout_gun;

        }

        public static RecyclerItemViewHolder newInstance(View parent) {
            TextView titleTextView = (TextView) parent.findViewById(R.id.titleTextView);
            TextView startDateTextView = (TextView) parent.findViewById(R.id.startDateTextView);
            TextView endDateTextView = (TextView) parent.findViewById(R.id.endDateTextView);
            NetworkImageView imageView = (NetworkImageView) parent.findViewById(R.id.imageView);
            TextView Profilid = (TextView) parent.findViewById(R.id.etkinlikId);
            TextView kalanGun = (TextView) parent.findViewById(R.id.kalan_gun);

            LinearLayout layout = (LinearLayout) parent.findViewById(R.id.layout_gun);

            return new RecyclerItemViewHolder(parent, titleTextView, startDateTextView,
                    endDateTextView, imageView, Profilid, kalanGun, layout);
        }


        //Burada problem vardi.CharSequence text tek olarak tanımlanmıstı.
        // (CharSequence text,CharSequence texta,CharSequence textb) yaptık.

        public void setItemText(CharSequence text, CharSequence texta, CharSequence textb, CharSequence id, CharSequence kalanGun) {
            mTitleTextView.setText(text);
            mStartDateTextView.setText(texta);
            mEndDateTextView.setText(textb);
            profilid.setText(id);
            if (kalanGun.equals("-")) {
                layout.setVisibility(View.GONE);
            } else layout.setVisibility(View.VISIBLE);
            days.setText(kalanGun);

        }

        public void setmImageView(String image) {
            if (imageLoader == null) {
                imageLoader = AppController.getInstance().getImageLoader();
            }
            mImageView.setImageUrl(image, imageLoader);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), EtkinlikIcerikActivity.class);
            i.putExtra(Etkinlik.ETKINLIK_ID, profilid.getText());
            v.getContext().startActivity(i);
        }
    }


}
