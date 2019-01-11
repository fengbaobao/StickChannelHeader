package com.moonrock.stickchannelheader.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by linkang on 2019/1/4.
 */

public class DisplayInfoUtils {

    public static int dipToPX(final Context ctx, float dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, ctx.getResources().getDisplayMetrics());
    }


}
