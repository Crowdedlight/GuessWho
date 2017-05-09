package ovh.crow.guesswho;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PortraitAdapter extends ArrayAdapter<Person> implements CompoundButton.OnCheckedChangeListener {
    private SparseBooleanArray mCheckStates;

    public PortraitAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mCheckStates = new SparseBooleanArray();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context mContext = getContext();
        //get data item for this position
        Person person = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_board_view, parent, false);
        }

        //set stuff
        final ImageView ivPerson = (ImageView) convertView.findViewById(R.id.ivPortrait);
        ivPerson.setTag(position);

        ColorMatrix matrix = new ColorMatrix();
        ColorMatrixColorFilter filter;

        if (isChecked(position)) {
            //Toggle grayscale on image
            matrix.setSaturation(0);
            filter = new ColorMatrixColorFilter(matrix);
            ivPerson.setColorFilter(filter);
        } else {
            ivPerson.clearColorFilter();
        }

        int resID = mContext.getResources().getIdentifier(person.getImgName(), "drawable", mContext.getPackageName());
        ivPerson.setImageResource(resID);

        return convertView;
    }

    public boolean isChecked(int position) {
        return mCheckStates.get(position, false);
    }

    public void setChecked(int position, boolean isChecked) {
        mCheckStates.put(position, isChecked);
    }

    public void toggle(int position) {
        setChecked(position, !isChecked(position));
        this.notifyDataSetChanged();
    }
    @Override
    public void onCheckedChanged(CompoundButton imageView, boolean isChecked) {
        mCheckStates.put((Integer) imageView.getTag(), isChecked);
    }
}