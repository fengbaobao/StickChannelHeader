package com.moonrock.stickchannelheader.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moonrock.stickchannelheader.R;

/**
 * Created by linkang on 2019/1/6.
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {

    private final Context mContext;
    private final String mTitle;

    public ContentAdapter(Context context, String title) {
        this.mContext = context;
        this.mTitle = title;
    }

    @Override
    public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View innerItem = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_inner_item, parent, false);
        TextView tv = (TextView) innerItem.findViewById(R.id.tv_itemLabel);
        tv.setPadding(50, 20, 50, 20);

        return new ContentHolder(innerItem);
    }

    @Override
    public void onBindViewHolder(ContentHolder holder, int position) {
        holder.setText(mTitle + " position[ " + position + " ]");
        if (position % 2 == 0) {
            holder.tvItemLabel.setBackgroundColor(Color.GREEN);
        } else {
            holder.tvItemLabel.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return 5000;
    }


    public static class ContentHolder extends RecyclerView.ViewHolder {

        private final TextView tvItemLabel;

        public ContentHolder(View itemView) {
            super(itemView);
            tvItemLabel = (TextView) itemView.findViewById(R.id.tv_itemLabel);
        }

        public void setText(String content) {
            tvItemLabel.setText(content);
        }

    }

}
