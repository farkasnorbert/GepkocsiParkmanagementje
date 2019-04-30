package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;
import com.applandeo.materialcalendarview.CalendarUtils;

public final class DrawableUtils {

    public static Drawable getCircleDrawableWithText(Context context, String string, int i) {
        Drawable background = ContextCompat.getDrawable(context, i);
        Drawable text = CalendarUtils.getDrawableText(context, string, null, android.R.color.white, 12);

        Drawable[] layers = {background, text};
        return new LayerDrawable(layers);
    }

    private DrawableUtils() {
    }
}