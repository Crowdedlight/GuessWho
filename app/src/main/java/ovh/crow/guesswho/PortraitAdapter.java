package ovh.crow.guesswho;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        final Context mContext = getContext();
        //get data item for this position
        Person person = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_board_view, parent, false);
        }

        //set stuff
        final ImageView ivPerson = (ImageView) convertView.findViewById(R.id.ivPortrait);

        int resID = mContext.getResources().getIdentifier(person.getImgName(), "drawable", mContext.getPackageName());
        ivPerson.setImageResource(resID);

        //click effect
        ivPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(mContext.getApplicationContext(),R.anim.fade_in);
                ivPerson.startAnimation(animFadein);

                //Game logic code, guessing on this or what happens? TODO
            }
        });

        return convertView;
    }
}
