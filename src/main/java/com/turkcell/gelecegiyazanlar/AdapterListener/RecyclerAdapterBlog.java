package com.turkcell.gelecegiyazanlar.AdapterListener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.turkcell.gelecegiyazanlar.Activity.BlogIcerikAcitivity;
import com.turkcell.gelecegiyazanlar.Activity.ProfilActivity;
import com.turkcell.gelecegiyazanlar.Configuration.AppController;
import com.turkcell.gelecegiyazanlar.Model.Blog;
import com.turkcell.gelecegiyazanlar.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapterBlog extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private List<Blog> mItemList;
    Activity activity;



    public RecyclerAdapterBlog(List<Blog> mItemList, Activity activity) {
        this.mItemList = mItemList;
        this.activity = activity;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_blog, parent, false);
        return RecyclerItemViewHolder.newInstance(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        Blog blog = mItemList.get(position);
        String title = blog.getTitle();
        String date = blog.getDate();
        String author= blog.getAuthor();
        String excerpt = blog.getExcerpt();
        String categories = blog.getCategories();
        String foto = blog.getImage();
        String avatar = blog.getAvatar();
        String profilID=blog.getProfilID();
        String blogID=blog.getBlogID();

        holder.setItemText(title, date, author, Html.fromHtml(excerpt), categories,profilID,blogID);
        holder.setItemImage(foto);
        holder.setItemAvatar(avatar);

    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mItemTextView;
        private final TextView mItemTextView1;
        private final TextView mItemTextView2;
        private final TextView mItemTextView3;
        private final TextView mItemTextView4;
        private final TextView mItemTextViewID;
        private final TextView blogsID;
        private NetworkImageView image;
        private CircleImageView avatar;

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();


        public RecyclerItemViewHolder(final View parent, TextView title, TextView date, TextView author, TextView excerpt, TextView categories, NetworkImageView networkImageView, CircleImageView avatarImage,TextView profilID,TextView blogID) {
            super(parent);
            parent.setClickable(true);
            parent.setOnClickListener(this);
            mItemTextView = title;
            mItemTextView1 = date;
            mItemTextView2 = author;
            mItemTextView3 = excerpt;
            mItemTextView4 = categories;
            mItemTextViewID = profilID;
            image = networkImageView;
            avatar = avatarImage;
            blogsID=blogID;

        }


        public static RecyclerItemViewHolder newInstance(final View parent) {
            TextView blogID = (TextView) parent.findViewById(R.id.blogID);
            TextView title = (TextView) parent.findViewById(R.id.itemBaslik);
            TextView date = (TextView) parent.findViewById(R.id.blogTarih);
            TextView author = (TextView) parent.findViewById(R.id.profilIsim);
            TextView excerpt = (TextView) parent.findViewById(R.id.itemOzet);
            TextView categories = (TextView) parent.findViewById(R.id.categories);
            final TextView profileID = (TextView) parent.findViewById(R.id.profilID);

            NetworkImageView image = (NetworkImageView) parent.findViewById(R.id.image);
            CircleImageView avatar = (CircleImageView) parent.findViewById(R.id.profile_image);

            avatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(parent.getContext(), ProfilActivity.class);
                    i.putExtra("id", profileID.getText());
                    parent.getContext().startActivity(i);
                }
            });

            return new RecyclerItemViewHolder(parent, title, date, author, excerpt, categories, image, avatar,profileID,blogID);
        }

        public void setItemText(String title, CharSequence date, CharSequence author, CharSequence excerpt, CharSequence categories,CharSequence profilID,CharSequence blogID) {
            mItemTextView.setText(title);
            mItemTextView1.setText(date);
            mItemTextView2.setText(author);
            mItemTextView3.setText(excerpt);
            mItemTextView4.setText(categories);
            mItemTextViewID.setText(profilID);
            blogsID.setText(blogID);


        }

        public void setItemImage(String itemImage) {
            if (imageLoader == null)
                imageLoader = AppController.getInstance().getImageLoader();
            image.setImageUrl(itemImage, imageLoader);
        }

        public void setItemAvatar(String itemImage) {
            ImageRequest im = new ImageRequest(itemImage, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    avatar.setImageBitmap(response);


                }
            }, 0, 0, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            AppController.getInstance().addToRequestQueue(im);
        }

        @Override
        public void onClick(View v) {
            Log.d("tag:",blogsID.getText().toString());
            Intent i=new Intent(v.getContext(), BlogIcerikAcitivity.class);
            i.putExtra("blogID",blogsID.getText());
            v.getContext().startActivity(i);
        }
    }

    }

