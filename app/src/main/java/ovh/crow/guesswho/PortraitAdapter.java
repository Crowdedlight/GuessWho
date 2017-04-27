package ovh.crow.guesswho;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


public class PortraitAdapter extends ArrayAdapter<Person> {

    public PortraitAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        Person person = (Person) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_board_view, parent, false);
        }

        //set stuff
        ImageView imPerson = (ImageView) convertView.findViewById(R.id.ivPortrait);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);

        tvName.setText(person.getName());
        imPerson.set

        return convertView;
    }
}
