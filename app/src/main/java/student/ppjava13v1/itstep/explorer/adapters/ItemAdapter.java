package student.ppjava13v1.itstep.explorer.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

import student.ppjava13v1.itstep.explorer.FileManager;
import student.ppjava13v1.itstep.explorer.R;
import student.ppjava13v1.itstep.explorer.model.ItemModel;

public class ItemAdapter extends ArrayAdapter<ItemModel> {

    List<ItemModel> records;

    public ItemAdapter(Context context, int resource, List<ItemModel> records) {
        super(context, resource, records);
        this.records = records;
    }

    private LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View currentView;
        if (convertView == null) {
            currentView =  inflater.inflate(R.layout.item, null);
        } else {
            currentView = convertView;
        }

        Button button = (Button) currentView.findViewById(R.id.btn_item);

        button.setText(getItem(position).getPath().getName());

        button.setCompoundDrawablesWithIntrinsicBounds(null, getItem(position).getImage(), null, null);
        button.setTag(getItem(position));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemModel model = (ItemModel) v.getTag();
                setRecords(FileManager.getFiles(model.getPath(), getContext()));
                ((Activity)getContext()).setTitle(FileManager.getCurrentDirectory().getAbsolutePath());
            }
        });

        return currentView;
    }

    public void setRecords(List<ItemModel> records) {
        this.records.clear();
        this.records.addAll(records);
        notifyDataSetChanged();
    }
}
