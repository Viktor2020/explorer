package student.ppjava13v1.itstep.explorer.model;

import android.graphics.drawable.Drawable;

import java.io.File;

public class ItemModel {

    private long id;

    private File path;

    private Drawable image;

    public ItemModel(File path, Drawable image) {
        this.path = path;
        this.image = image;
    }

    public ItemModel(long id, File path, Drawable image) {
        this.id = id;
        this.path = path;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }


}
