package basketapp.vjdevmobile.com.basket.model;

public class RuleModel {
    private String kode;
    private String title;
    private int image;

    public RuleModel(String kode, String title, int image) {
        this.kode = kode;
        this.title = title;
        this.image = image;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
