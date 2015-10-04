package student.ppjava13v1.itstep.explorer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import student.ppjava13v1.itstep.explorer.R;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        Fragment items = new ItemsFragment();

        Fragment navigate = new NavigationFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.navigation_frame, navigate)
                .add(R.id.items_frame, items)
                .commit();

        return rootView;
    }
}
