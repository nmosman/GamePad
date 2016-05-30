package com.example.nasir.droidmote;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

/**
 * Created by Nasir on 2016-05-08.
 */
public class ArrayAdapterItem extends ArrayAdapter<String> {
    private Context mContext;
    private int id;

    public ArrayAdapterItem(Context mContext, int id)
    {
        super(mContext, id);
    }


}
