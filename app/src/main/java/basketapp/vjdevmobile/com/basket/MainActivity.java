package basketapp.vjdevmobile.com.basket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import basketapp.vjdevmobile.com.basket.activity.InfoAplikasiActivity;
import basketapp.vjdevmobile.com.basket.activity.ModelLatihanActivity;
import basketapp.vjdevmobile.com.basket.activity.PetunjukActivity;
import basketapp.vjdevmobile.com.basket.activity.SejarahActivity;
import basketapp.vjdevmobile.com.basket.activity.TeknikDasarActivity;
import basketapp.vjdevmobile.com.basket.activity.VideoActivity;
import basketapp.vjdevmobile.com.basket.helper.Helper;
import basketapp.vjdevmobile.com.basket.model.MenuModel;
import basketapp.vjdevmobile.com.basket.util.ItemDecorationColumns;

public class MainActivity extends AppCompatActivity {

    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MenuModel> list = Helper.getMenuDashboard();

        RecyclerView listRow = (RecyclerView) findViewById(R.id.recyclerview);

        DasboardAdapter adapter = new DasboardAdapter(list, this);
        listRow.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        listRow.setLayoutManager(manager);
        listRow.addItemDecoration(new ItemDecorationColumns(2, 2));
    }

    private class DasboardAdapter extends RecyclerView.Adapter<DasboardAdapter.ViewHolder>{

        List<MenuModel> list;
        Context context;

        public DasboardAdapter(List<MenuModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_menu, viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.title_tv.setText(list.get(i).getTitle());
            viewHolder.imageView.setImageResource(list.get(i).getImage());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView title_tv;
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                title_tv = (TextView) itemView.findViewById(R.id.tv_title);
                imageView =(ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

                if (getPosition() == 0) {
                    startActivity(new Intent(v.getContext(), SejarahActivity.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(v.getContext(), TeknikDasarActivity.class));
                } else if (getPosition() == 2) {
                    startActivity(new Intent(v.getContext(), ModelLatihanActivity.class));
                } else if (getPosition() == 3) {
                    startActivity(new Intent(v.getContext(), InfoAplikasiActivity.class));
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Anda yakin akan keluar dari aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Ya, Keluar!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", null);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // aksi logout dan mengembalikan ke login page
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, PetunjukActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
