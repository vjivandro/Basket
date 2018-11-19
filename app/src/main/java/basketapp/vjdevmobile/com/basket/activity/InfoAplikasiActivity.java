package basketapp.vjdevmobile.com.basket.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import basketapp.vjdevmobile.com.basket.R;
import basketapp.vjdevmobile.com.basket.helper.Helper;
import basketapp.vjdevmobile.com.basket.model.MenuModel;

public class InfoAplikasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        List<MenuModel> info = Helper.getInfoAplikasi();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        InfoAppAdapter appAdapter = new InfoAppAdapter(info, this);
        recyclerView.setAdapter(appAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private class InfoAppAdapter extends RecyclerView.Adapter<InfoAppAdapter.ViewHolder> {

        List<MenuModel> listInfo;
        Context context;

        public InfoAppAdapter(List<MenuModel> listInfo, Context context) {
            this.listInfo = listInfo;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_infoapp, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title_tv.setText(listInfo.get(position).getTitle());
            holder.imageView.setImageResource(listInfo.get(position).getImage());
        }

        @Override
        public int getItemCount() {
            return listInfo.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView title_tv;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);

                title_tv = (TextView) itemView.findViewById(R.id.tv_title);
                imageView = (ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (getPosition() == 0) {
                    startActivity(new Intent(v.getContext(), ProfileActivity.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(v.getContext(), DeskripsiActivity.class));
                } else if (getPosition() == 2) {
                    AlertDialog.Builder alertadd = new AlertDialog.Builder(itemView.getContext());
                    alertadd.setMessage("Tujuan Instruksional");
                    alertadd.setIcon(R.mipmap.ic_launcher);
                    LayoutInflater factory = LayoutInflater.from(itemView.getContext());
                    View view = factory.inflate(R.layout.item_dialog, null);
                    TextView detail_tv = (TextView) view.findViewById(R.id.tv_detail);
                    detail_tv.setText(R.string.tujuan);
                    alertadd.setView(view);
                    alertadd.setCancelable(true);
                    alertadd.setPositiveButton("Tutup", null);
                    alertadd.show();
                } else if (getPosition() == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(InfoAplikasiActivity.this);
                    builder.setTitle("Mobile Developer");
                    builder.setIcon(R.mipmap.ic_dev_mobile);
                    builder.setMessage("Juris Vassa Ivandro, S.Kom\n082143594666\nvjdevmobile@gmail.com");
                    builder.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                } else if (getPosition() == 4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(InfoAplikasiActivity.this);
                    builder.setTitle("Analyst");
                    builder.setIcon(R.mipmap.ic_dev_mobile);
                    builder.setMessage("Eko Hadi Santoso, Amd.Kom\n082245493396\nekohs2009@gmail.com");
                    builder.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                } else if (getPosition() == 5) {
                    startActivity(new Intent(v.getContext(), AboutActivity.class));
                }
            }
        }
    }
}