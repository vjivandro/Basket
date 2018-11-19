package basketapp.vjdevmobile.com.basket.helper;

import java.util.ArrayList;
import java.util.List;

import basketapp.vjdevmobile.com.basket.R;
import basketapp.vjdevmobile.com.basket.model.MenuModel;
import basketapp.vjdevmobile.com.basket.model.RuleModel;

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

    // Menu Model Latihan
    public static List<MenuModel> getModelLatihan() {
        List<MenuModel> menulatihan = new ArrayList<MenuModel>();
        menulatihan.add(new MenuModel("Model Latihan Shooting Bola Basket", R.mipmap.ic_cara));
        menulatihan.add(new MenuModel("Video Model Latihan Shooting Bola Basket", R.mipmap.ic_video));

        return menulatihan;
    }

    // Menu Info
    public static List<MenuModel> getInfoAplikasi(){

        List<MenuModel> listInfo = new ArrayList<MenuModel>();
        listInfo.add(new MenuModel("Profil", R.mipmap.ic_user));
        listInfo.add(new MenuModel("Deskripsi", R.mipmap.ic_deskrip));
        listInfo.add(new MenuModel("Tujuan", R.mipmap.ic_goal));
        listInfo.add(new MenuModel("Developer", R.mipmap.ic_dev_mobile));
        listInfo.add(new MenuModel("Analyst", R.mipmap.ic_editor));
        listInfo.add(new MenuModel("About", R.mipmap.ic_about_app));

        return listInfo;
    }

    // Menu Petunjuk
    public static List<RuleModel> getRule(){

        List<RuleModel> listRule = new ArrayList<RuleModel>();
        listRule.add(new RuleModel("1","Sejarah", R.mipmap.ic_materi));
        listRule.add(new RuleModel("2","Teknik Dasar", R.mipmap.ic_basic));
        listRule.add(new RuleModel("3","Model Latihan", R.mipmap.ic_combine));
        listRule.add(new RuleModel("4","Submenu Model Latihan", R.mipmap.ic_cara));
        listRule.add(new RuleModel("5","Submenu Video Model Latihan", R.mipmap.ic_video));
        listRule.add(new RuleModel("6","Info Aplikasi", R.mipmap.ic_info));
        listRule.add(new RuleModel("7","Submenu Profile", R.mipmap.ic_user));
        listRule.add(new RuleModel("8","Submenu Deskripsi", R.mipmap.ic_deskrip));
        listRule.add(new RuleModel("9","Alert Developer", R.mipmap.ic_dev_mobile));
        listRule.add(new RuleModel("10","Alert Analyst", R.mipmap.ic_editor));
        listRule.add(new RuleModel("11","Submenu About", R.mipmap.ic_about_app));

        return listRule;
    }
}
