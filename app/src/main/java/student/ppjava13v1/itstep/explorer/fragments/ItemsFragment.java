package student.ppjava13v1.itstep.explorer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import student.ppjava13v1.itstep.explorer.R;

public class ItemsFragment extends Fragment {

    public static final String TAG = "ItemsFragmentTAG";

    private ListAdapter adapter;

    int resource = ContentLocation.LIST.id; // default LIST

    public static ItemsFragment newInstance(ListAdapter adapter) {
        ItemsFragment itemsFragment = new ItemsFragment();
        itemsFragment.adapter = adapter;
        return itemsFragment;
    }

    public static ItemsFragment newInstance(ListAdapter adapter, ContentLocation resource) {
        ItemsFragment itemsFragment = new ItemsFragment();
        itemsFragment.adapter = adapter;
        itemsFragment.resource = resource.id;
        return itemsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(resource, container, false);

        AbsListView view = (AbsListView) rootView.findViewById(R.id.list);
        view.setAdapter(adapter);
        registerForContextMenu(view);

        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.my_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_cut:
                return true;
            case R.id.menu_delete:
                return true;
            case R.id.menu_copy:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
