package student.ppjava13v1.itstep.explorer;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import student.ppjava13v1.itstep.explorer.model.ItemModel;

public class FileManager {

    private static File currentDirectory;

    public static void createFolder(File path, String folderName) {
        new File(path, folderName).mkdir();
    }

    public static void createFile(File path, String fileName) {
        try {
            if (new File(path, fileName).createNewFile()) {
                Log.wtf("createFile ", fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ItemModel> getFiles(File directory, Context context) {
        if (directory == null) {
            directory = context.getFileStreamPath("");
        }

        currentDirectory = directory;

        List<ItemModel> itemModels = new ArrayList<>();
        File[] path = currentDirectory.listFiles();
        Resources res = context.getResources();
        if (path != null) {
            for (File p : path) {
                Drawable drawable;
                if (p.isDirectory()) {
                    drawable = res.getDrawable(R.drawable.ic_folder_black_24dp);
                } else {
                    drawable = res.getDrawable(R.drawable.ic_insert_drive_file_black_24dp);
                }
                ItemModel model = new ItemModel(p, drawable);

                itemModels.add(model);
            }
        }
        return itemModels;
    }

    public static File getCurrentDirectory() {
        return currentDirectory;
    }
}
