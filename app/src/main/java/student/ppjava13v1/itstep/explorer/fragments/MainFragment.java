package student.ppjava13v1.itstep.explorer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import student.ppjava13v1.itstep.explorer.FileManager;
import student.ppjava13v1.itstep.explorer.R;
import student.ppjava13v1.itstep.explorer.adapters.ItemAdapter;
import student.ppjava13v1.itstep.explorer.dialogs.CreateFileDialogFragment;
import student.ppjava13v1.itstep.explorer.model.ItemModel;

public class MainFragment extends Fragment implements OnChangeLayout, CreateFileDialogFragment.CreateFileListener
        , CreateFileDialogFragment.CreateFolderListener {

    public static final String TAG = "MainFragmentTAG";

    private ItemAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        List<ItemModel> itemModels = FileManager.getFiles(getActivity().getFileStreamPath("").getParentFile(), getActivity());

        listAdapter = new ItemAdapter(getActivity(), 0, itemModels);

        Fragment items = ItemsFragment.newInstance(listAdapter);

        Fragment navigate = NavigationFragment.newInstance(listAdapter, this, this, this);

        getFragmentManager().beginTransaction()
                .add(R.id.navigation_frame, navigate, NavigationFragment.TAG)
                .add(R.id.items_frame, items, ItemsFragment.TAG)
                .commit();

        return rootView;
    }

    public void changeLayout(ContentLocation contentLocation) {
        getFragmentManager().beginTransaction()
                .replace(R.id.items_frame, ItemsFragment.newInstance(listAdapter, contentLocation), ItemsFragment.TAG)
                .commit();
    }


    @Override
    public void createFile(String fileName) {
        FileManager.createFile(FileManager.getCurrentDirectory(), fileName);
        listAdapter.setRecords(FileManager.getFiles(FileManager.getCurrentDirectory(), getActivity()));
    }

    @Override
    public void createFolder(String folderName) {
        FileManager.createFolder(FileManager.getCurrentDirectory(), folderName);
        listAdapter.setRecords(FileManager.getFiles(FileManager.getCurrentDirectory(), getActivity()));
    }
}
