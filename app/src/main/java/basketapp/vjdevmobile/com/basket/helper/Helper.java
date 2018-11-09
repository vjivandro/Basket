package basketapp.vjdevmobile.com.basket.helper;

import java.util.ArrayList;
import java.util.List;

import basketapp.vjdevmobile.com.basket.R;
import basketapp.vjdevmobile.com.basket.model.MenuModel;

public class Helper {
    // Dashboard
    public static List<MenuModel> getMenuDashboard() {
        List<MenuModel> lisDashboard = new ArrayList<MenuModel>();
        lisDashboard.add(new MenuModel("Sejarah", R.mipmap.ic_materi));
        lisDashboard.add(new MenuModel("Teknik Dasar", R.mipmap.ic_basic));
        lisDashboard.add(new MenuModel("Model Latihan", R.mipmap.ic_combine));
        lisDashboard.add(new MenuModel("Info Aplikasi", R.mipmap.ic_info));
        return lisDashboard;
    }
}
