package nms.az.onlineacademy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nms.az.onlineacademy.R;

/**
 * Created by anar on 8/14/15.
 */
public class CategoryListAdapter extends ArrayAdapter<String> {

    private int resource;
    private List<String> categories;
    private LayoutInflater inflater;

    ViewHolder holder;

    public CategoryListAdapter(Context context, int resource, List<String> categories){
        super(context,resource,categories);

        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return categories.size();
    }


    @Override
    public String getItem(int position) {
        return categories.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            holder = new ViewHolder();
            convertView = inflater.inflate(resource,parent,false);

            holder.name = (TextView) convertView.findViewById(R.id.category_text_view_name);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.name.setText(categories.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView name;
    }

}
