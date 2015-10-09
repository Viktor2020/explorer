package student.ppjava13v1.itstep.explorer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;

import student.ppjava13v1.itstep.explorer.FileManager;
import student.ppjava13v1.itstep.explorer.R;
import student.ppjava13v1.itstep.explorer.adapters.ItemAdapter;

public class NavigationFragment extends Fragment {

    public static final String TAG = "NavigationFragmentTAG";

    private OnChangeLayout onChangeLayout;

    private ListAdapter adapter;

    public static NavigationFragment newInstance(ListAdapter adapter, OnChangeLayout onChangeLayout) {
        NavigationFragment itemsFragment = new NavigationFragment();
        itemsFragment.adapter = adapter;
        itemsFragment.onChangeLayout = onChangeLayout;
        return itemsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.navigation, container, false);

        ImageButton buttonUp = (ImageButton) rootView.findViewById(R.id.btn_up);

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ItemAdapter) adapter).setRecords(FileManager.getFiles(FileManager.getCurrentDirectory().getParentFile(), getActivity()));
                getActivity().setTitle(FileManager.getCurrentDirectory().getAbsolutePath());
            }
        });

        ImageButton buttonChangeLayoutGrid = (ImageButton) rootView.findViewById(R.id.btn_grid_layout);

        buttonChangeLayoutGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeLayout.changeLayout(ContentLocation.GRID);
            }
        });

        ImageButton buttonChangeLayoutList = (ImageButton) rootView.findViewById(R.id.btn_list_layout);

        buttonChangeLayoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeLayout.changeLayout(ContentLocation.LIST);
            }
        });


        return rootView;
    }
}
