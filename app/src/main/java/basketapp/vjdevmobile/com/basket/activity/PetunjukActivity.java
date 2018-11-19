package basketapp.vjdevmobile.com.basket.activity;

import android.content.Context;
import android.support.annotation.NonNull;
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
import basketapp.vjdevmobile.com.basket.model.RuleModel;

public class PetunjukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);

        List<RuleModel> ruleModelList = Helper.getRule();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        RuleAdapter adapter = new RuleAdapter(ruleModelList, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.ViewHolder>{

        List<RuleModel> listRule;
        Context context;
        String kode, content;

        public RuleAdapter(List<RuleModel> listRule, Context context) {
            this.listRule = listRule;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_petunjuk, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageResource(listRule.get(position).getImage());
            holder.kode_tv.setText(listRule.get(position).getKode());
            holder.title_tv.setText(listRule.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return listRule.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView kode_tv, title_tv, content_tv;
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                kode_tv = (TextView) itemView.findViewById(R.id.tv_kode);
                title_tv = (TextView) itemView.findViewById(R.id.tv_title);
                imageView = (ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
//                content = content_tv.getText().toString();
                kode = kode_tv.getText().toString();

                System.out.println(content);

//                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext())
//                        .setMessage(content)
//                        .setCancelable(true)
//                        .setPositiveButton("tutup", null);
//                builder.create();
//                builder.show();

                AlertDialog.Builder alertadd = new AlertDialog.Builder(itemView.getContext());
                alertadd.setMessage("Detail Petunjuk");
                alertadd.setIcon(R.mipmap.ic_launcher);
                LayoutInflater factory = LayoutInflater.from(itemView.getContext());
                View view = factory.inflate(R.layout.item_dialog, null);
                TextView detail_tv = (TextView) view.findViewById(R.id.tv_detail);
                if (kode.equals("1")) {
                    detail_tv.setText(R.string.content_sejarah);
                } else if (kode.equals("2")) {
                    detail_tv.setText(R.string.content_teknik);
                } else if (kode.equals("3")) {
                    detail_tv.setText(R.string.content_modellatihan);
                } else if (kode.equals("4")) {
                    detail_tv.setText(R.string.content_modellatihan_cara);
                } else if (kode.equals("5")) {
                    detail_tv.setText(R.string.content_modellatihan_video);
                } else if (kode.equals("6")) {
                    detail_tv.setText(R.string.content_infoapp);
                } else if (kode.equals("7")) {
                    detail_tv.setText(R.string.content_infoapp_profile);
                } else if (kode.equals("8")) {
                    detail_tv.setText(R.string.content_infoapp_deskripsi);
                } else if (kode.equals("9")) {
                    detail_tv.setText(R.string.content_infoapp_dev);
                } else if (kode.equals("10")) {
                    detail_tv.setText(R.string.content_infoapp_analyst);
                } else if (kode.equals("11")) {
                    detail_tv.setText(R.string.content_infoapp_about);
                }

                alertadd.setView(view);
                alertadd.setCancelable(true);
                alertadd.setPositiveButton("Tutup", null);
                alertadd.show();

            }
        }

    }
}
