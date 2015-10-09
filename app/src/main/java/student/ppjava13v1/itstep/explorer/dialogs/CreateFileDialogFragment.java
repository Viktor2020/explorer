package student.ppjava13v1.itstep.explorer.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import student.ppjava13v1.itstep.explorer.R;

public class CreateFileDialogFragment extends DialogFragment {

    public static final String TAG = "CreateFileDialogFragmentTAG";

    private CreateFileListener fileListener;
    private CreateFolderListener folderListener;

    public static CreateFileDialogFragment newInstance(CreateFileListener fileListener, CreateFolderListener folderListener) {
        CreateFileDialogFragment createFileDialogFragment = new CreateFileDialogFragment();
        createFileDialogFragment.fileListener = fileListener;
        createFileDialogFragment.folderListener = folderListener;
        return createFileDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_create_file, null);
        final EditText etName = (EditText) view.findViewById(R.id.et_name_file);

        builder.setView(view);

        builder.setPositiveButton("Create File", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fileListener.createFile(etName.getText().toString());
            }
        });

        builder.setNeutralButton("Create Folder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                folderListener.createFolder(etName.getText().toString());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });



        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }

    public interface CreateFileListener {
        void createFile(String fileName);
    }

    public interface CreateFolderListener {
        void createFolder(String folderName);
    }
}
