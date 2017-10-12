package com.xabber.android.ui.widget.bottomnavigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xabber.android.R;

import java.util.ArrayList;

/**
 * Created by valery.miller on 06.10.17.
 */

public class AccountShortcutAdapter extends RecyclerView.Adapter<AccountShortcutAdapter.ViewHolder> {

    private ArrayList<AccountShortcutVO> items;
    private Context context;

    public AccountShortcutAdapter(ArrayList<AccountShortcutVO> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivAvatar;
        public ImageView ivStatus;

        public ViewHolder(View v) {
            super(v);
            ivAvatar = (ImageView) v.findViewById(R.id.ivAvatar);
            ivStatus = (ImageView) v.findViewById(R.id.ivStatus);
        }
    }


    @Override
    public AccountShortcutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avatar_view_xsmall, parent, false);

        // set equals view sizes
        if (getItemCount() < 6) {
            int height = 44;
            final float scale = context.getResources().getDisplayMetrics().density;
            int pixelsHeight = (int) (height * scale + 0.5f);

            int width = parent.getMeasuredWidth() / getItemCount();

            view.setLayoutParams(new RecyclerView.LayoutParams(width, pixelsHeight));
        }

        return new AccountShortcutAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AccountShortcutAdapter.ViewHolder holder, int position) {

        AccountShortcutVO account = items.get(position);
        holder.ivAvatar.setImageDrawable(account.getAvatar());
        holder.ivStatus.setImageLevel(account.getStatusLevel());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}