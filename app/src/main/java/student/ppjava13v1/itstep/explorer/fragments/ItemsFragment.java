package student.ppjava13v1.itstep.explorer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import student.ppjava13v1.itstep.explorer.R;

public class ItemsFragment extends Fragment {

    private ListAdapter adapter;

    public static ItemsFragment newInstance(ListAdapter adapter) {
        ItemsFragment itemsFragment = new ItemsFragment();
        itemsFragment.adapter = adapter;
        return itemsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_item_grid, container, false);

        AbsListView view = (AbsListView) rootView.findViewById(R.id.list);
        view.setAdapter(adapter);

        return rootView;
    }
}
