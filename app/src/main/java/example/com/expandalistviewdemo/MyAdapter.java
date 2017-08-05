package example.com.expandalistviewdemo;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by joseph on 2017/08/05.
 */

public class  MyAdapter extends BaseExpandableListAdapter {

    private  String title;

    private  HashMap<String, String> holder = new HashMap<>();

    public MyAdapter(String title){
        this.title = title;
    }
    @Override
    public int getGroupCount() {
        return 3;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);


        TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title);
        titleTextView.setText(title + " " + (groupPosition + 1));

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);

        final EditText etFirstName = (EditText) convertView.findViewById(R.id.et_first_name);
        final String value =  holder.get(String.valueOf(groupPosition + childPosition));

        etFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                holder.put(String.valueOf(groupPosition + childPosition), s.toString());
            }
        });

        if (value != null){
            etFirstName.setText(value);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
