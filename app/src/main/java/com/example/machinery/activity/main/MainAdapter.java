package com.example.machinery.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.machinery.model.Department;
import com.example.retrofit.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    Context context;
    List<Department> departmentList;
    ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<Department> notes, ItemClickListener itemClickListener) {
        this.context = context;
        this.departmentList = notes;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_note,
                parent, false);
        return new RecyclerViewAdapter( view, itemClickListener );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        Department note = departmentList.get(position);
        holder.tv_department_code.setText( note.getDepartment_code() );
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_department_code;
        CardView card_item;
        ItemClickListener itemClickListener;

        RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super( itemView );
            this.itemClickListener = itemClickListener;

            tv_department_code = itemView.findViewById( R.id.department_code );
            card_item = itemView.findViewById( R.id.card_item );

            this.itemClickListener = itemClickListener;
            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick( v, getAdapterPosition() );
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
