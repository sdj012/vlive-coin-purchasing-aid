package com.example.coinpurchaseaid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ListItemHolder> {

    private List<Option> mOptionList;
    private MainActivity mMainActivity;


    public NoteAdapter(MainActivity mainActivity, List<Option> optionList){ // NoteAdapt. Cons.
        mMainActivity = mainActivity;
        mOptionList = optionList;
    }

    @NonNull
    @Override
    public  NoteAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);

        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {

        Option option = mOptionList.get(position);
        holder.mTitle.setText(option.getTitle());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

        public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //Inner Class ListItemHolder

            TextView mTitle;
            TextView mDescription;
            TextView mStatus;

            public ListItemHolder(View view){ //ListItemHolder Cons.
                super(view);
//                mTitle=(TextView)view.findViewById(R.id.textViewTitle);
//
//                mDescription=(TextView)view.findViewById(R.id.textViewDescription);
//
//                mStatus=(TextView)view.findViewById(R.id.textViewStatus);

                view.setClickable(true);
                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View view){};

        }
}
