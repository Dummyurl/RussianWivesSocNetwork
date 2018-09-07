package com.borisruzanov.russianwives.ui.pagination;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.borisruzanov.russianwives.OnItemClickListener;
import com.borisruzanov.russianwives.R;
import com.borisruzanov.russianwives.models.FsUser;
import com.bumptech.glide.Glide;
import com.firebase.ui.auth.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.UserViewHolder>{
    //TODO REMOVE OR DELETE?
    private List<FsUser> fsUserList = new ArrayList<>();
    /*private OnMultipleItemClickListener.OnMultipleItemClickCallback onItemClickCallback;
    private OnMultipleItemClickListener.OnChatClickCallback onChatClickCallback;
    private OnMultipleItemClickListener.OnLikeClickCallback onLikeClickCallback;*/
    private OnItemClickListener.OnItemClickCallback onItemClickCallback;
    private OnItemClickListener.OnItemClickCallback onChatClickCallback;
    private OnItemClickListener.OnItemClickCallback onLikeClickCallback;
    Context context;

    public SearchAdapter(OnItemClickListener.OnItemClickCallback onItemClickCallback,
                         OnItemClickListener.OnItemClickCallback onChatClickCallback,
                         OnItemClickListener.OnItemClickCallback onLikeClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
        this.onChatClickCallback = onChatClickCallback;
        this.onLikeClickCallback = onLikeClickCallback;
    }


    /*public SearchAdapter(OnMultipleItemClickListener.OnMultipleItemClickCallback onItemClickCallback, OnMultipleItemClickListener.OnChatClickCallback onChatClickCallback, OnMultipleItemClickListener.OnLikeClickCallback onLikeClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
        this.onChatClickCallback = onChatClickCallback;
        this.onLikeClickCallback = onLikeClickCallback;
    }*/

//    public SearchAdapter(OnItemClickListener.OnItemClickCallback onItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback;
//    }

    public void setData(List<FsUser> newFsUsers) {
        Log.d("LifecycleDebug", "List in adapter list empty is "+ newFsUsers.isEmpty());
        for (FsUser fsUser : fsUserList) {
            Log.d("LifecycleDebug", "User name in adapter is "+ fsUser.getName());
        }
        fsUserList.addAll(newFsUsers);
        notifyDataSetChanged();
    }

    public void clearData(){
        fsUserList = new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        FsUser fsUser = fsUserList.get(position);
        holder.bind(fsUser, position);
    }

    @Override
    public int getItemCount() {
        return fsUserList.size();
    }

    public String getLastItemId(){
        return fsUserList.get(fsUserList.size() - 1).getUid();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        ImageView imageView, like, chat;
        TextView name, age, country;
//        Context context;

        UserViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            container = itemView.findViewById(R.id.item_user_container);
            imageView = itemView.findViewById(R.id.user_img);
            like = itemView.findViewById(R.id.search_btn_like);
            chat = itemView.findViewById(R.id.search_btn_chat);
            name = itemView.findViewById(R.id.user_name);
            age = itemView.findViewById(R.id.user_age);
            country = itemView.findViewById(R.id.user_country);
        }



        void bind(FsUser fsUser, int position){
//            chat.setOnClickListener(new OnMultipleItemClickListener(position, onItemClickCallback, onChatClickCallback, onLikeClickCallback));
//            like.setOnClickListener(new OnMultipleItemClickListener(position, onItemClickCallback, onChatClickCallback, onLikeClickCallback));
//            container.setOnClickListener(new OnMultipleItemClickListener(position, onItemClickCallback, onChatClickCallback, onLikeClickCallback));

            chat.setOnClickListener(new OnItemClickListener(position, onChatClickCallback));
            like.setOnClickListener(new OnItemClickListener(position, onLikeClickCallback));
            imageView.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            if(fsUser.getImage().equals("default")){
                Glide.with(context).load(context.getResources().getDrawable(R.drawable.default_avatar)).into(imageView);

            }else {
                Glide.with(context).load(fsUser.getImage()).thumbnail(0.5f).into(imageView);
            }
            name.setText(fsUser.getName());
            age.setText(fsUser.getAge());
            country.setText(fsUser.getCountry());
//            status.setText(fsUser.getStatus());
        }
    }

}
