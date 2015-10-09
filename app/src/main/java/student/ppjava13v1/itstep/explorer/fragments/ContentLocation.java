package student.ppjava13v1.itstep.explorer.fragments;

import student.ppjava13v1.itstep.explorer.R;

public enum ContentLocation {

    GRID (R.layout.fragment_item_grid),
    LIST (R.layout.fragment_item_list);

    int id;

    ContentLocation(int r) {
        this.id = r;
    }

    ;
}
