package com.lzro.feedmatic.PetList.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzro.feedmatic.PetList.contentModel.PetModel;
import com.lzro.feedmatic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablofuentes on 2/6/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

        private Context context;
        private List<PetModel> dataset;
        private OnPetItemClickListener onPetItemClickListener;

        public PetAdapter(Context context, List<PetModel> dataset, OnPetItemClickListener onPetItemClickListener) {
            this.context = context;
            this.dataset = dataset;
            this.onPetItemClickListener = onPetItemClickListener;
        }

        public PetAdapter(Context context, OnPetItemClickListener onPetItemClickListener) {
            this.context = context;
            this.dataset = new ArrayList<PetModel>();
            this.onPetItemClickListener = onPetItemClickListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PetModel element = dataset.get(position);
            String petName = element.getName();
            String lastFeed = element.getLastFeed();
            boolean petOnline = element.isOnline();

            holder.tvPetModel_Name.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            holder.tvPetModel_Online.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

            holder.tvPetModel_Name.setText(petName);
            holder.tvPetModel_Name.setTextColor(Color.DKGRAY);

            holder.tvPetModel_LastFeed.setText("últ. vez " + lastFeed);

            if (petOnline == true) {
                holder.tvPetModel_Online.setTextColor(Color.parseColor("#448AFF"));
                holder.tvPetModel_Online.setText("Conectado");
            } else {
                holder.tvPetModel_Online.setTextColor(Color.LTGRAY);
                holder.tvPetModel_Online.setText("Desconectado");
            }

            holder.setOnItemClickListener(element, onPetItemClickListener);
            holder.setOnItemTouchListener();
        }

        @Override
        public int getItemCount() {
            return dataset.size();
        }


        public void add(PetModel record) {
            dataset.add(0, record);
            notifyDataSetChanged();
        }

        public void clear() {
            dataset.clear();
            notifyDataSetChanged();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            RelativeLayout petItemLayout;
            TextView tvPetModel_Name;
            TextView tvPetModel_Online;
            TextView tvPetModel_LastFeed;

            public ViewHolder(View itemView) {
                super(itemView);
                petItemLayout = (RelativeLayout) itemView.findViewById(R.id.petItemLayout);
                tvPetModel_Name = (TextView) itemView.findViewById(R.id.tvPetModel_Name);
                tvPetModel_Online = (TextView) itemView.findViewById(R.id.tvPetModel_Online);
                tvPetModel_LastFeed = (TextView) itemView.findViewById(R.id.tvPetLastFeed);
            }

            public void setOnItemClickListener(final PetModel element, final OnPetItemClickListener onPetItemClickListener) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onPetItemClickListener.onPetItemClick(element);
                    }
                });
            }

            public void setOnItemTouchListener() {
                itemView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            petItemLayout.setBackgroundResource(R.drawable.round_corner_item_pressed);
                        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            petItemLayout.setBackgroundResource(R.drawable.round_corner_item);
                        }
                        return false;
                    }
                });
            }
        }
    }

