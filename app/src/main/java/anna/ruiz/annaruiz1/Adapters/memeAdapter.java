package anna.ruiz.annaruiz1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anna.ruiz.annaruiz1.Modelos.MemesItem;
import anna.ruiz.annaruiz1.R;

public class memeAdapter extends RecyclerView.Adapter<memeAdapter.MemeVH> {
    private Context context;
    private int resource;
    private List<MemesItem> objects;

    public memeAdapter(Context context, int resource, List<MemesItem> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public MemeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View memeView = LayoutInflater.from(context).inflate(resource,null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
        );
        memeView.setLayoutParams(lp);

        return new MemeVH(memeView);
    }

    @Override
    public void onBindViewHolder(@NonNull MemeVH holder, int position) {
        MemesItem mem = objects.get(position);


        holder.lbName.setText(mem.getName());
        holder.lbUrl.setText(mem.getUrl());
        holder.lbHeight.setText("Height: "+String.valueOf(mem.getHeight()));
        holder.lbWidth.setText("Width: " +String.valueOf(mem.getWidth()));

        holder.btnFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //accion favorito
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MemeVH extends RecyclerView.ViewHolder{
        TextView lbName;
        TextView lbUrl;
        TextView lbWidth;
        TextView lbHeight;
        ImageButton btnFavorito;

        public MemeVH(@NonNull View itemView) {
            super(itemView);

            lbName = itemView.findViewById(R.id.lbName);
            lbUrl = itemView.findViewById(R.id.lbUrl);
            lbWidth = itemView.findViewById(R.id.lbWidth);
            lbHeight = itemView.findViewById(R.id.lbHeight);
            btnFavorito = itemView.findViewById(R.id.btnFavorito);

        }



    }

}
