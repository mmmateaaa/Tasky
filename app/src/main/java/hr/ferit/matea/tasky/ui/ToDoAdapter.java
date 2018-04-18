package hr.ferit.matea.tasky.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import hr.ferit.matea.tasky.R;
import hr.ferit.matea.tasky.model.ToDo;

/**
 * Created by Matea on 4/18/2018.
 */

class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>{

    private List<ToDo> mToDos;
    private ToDoClickCallback mCallback;

    public ToDoAdapter(List<ToDo> todos, ToDoClickCallback onToDoClickListener) {
        mToDos = new ArrayList<>();
        this.refreshData(todos);
        mCallback = onToDoClickListener;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_to_do, parent, false);
        return new ToDoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo current = mToDos.get(position);
        holder.tvToDoTitle.setText(current.getTitle());
        holder.tvToDoDesc.setText(current.getDescription());
        Picasso.get()
                .load(current.getImgUrl())
                .centerCrop()
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(holder.ivToDoCover);
    }

    @Override
    public int getItemCount() {
        return mToDos.size();
    }

    public void refreshData(List<ToDo> toDos) {
        mToDos.clear();
        mToDos.addAll(toDos);
        this.notifyDataSetChanged();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivToDoCover) ImageView ivToDoCover;
        @BindView(R.id.tvToDoTitle) TextView tvToDoTitle;
        @BindView(R.id.tvToDoDesc) TextView tvToDoDesc;

        ToDoClickCallback mCallback;

        public ToDoViewHolder(View itemView, final ToDoClickCallback callback) {
            super(itemView);
            mCallback = callback;
            ButterKnife.bind(this, itemView);
        }

        @OnLongClick
        public boolean onToDoLongClick() {
            return mCallback.onLongClick(mToDos.get(getAdapterPosition()));
        }

    }
}
