package com.z.zviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Miller Zhang  on 2016/12/22.
 * desc:
 * github:https://github.com/zxyaust  CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */

public class ZRelativeLayout extends RelativeLayout {
    //defualt
    private final int DEFUALT_COLOR = Color.TRANSPARENT;
    private final int TYPE_DRAWABLE = 0, TYPE_COLOR = 1;
    private int zType = TYPE_DRAWABLE;
    //state defualt
    private int
            zColor = DEFUALT_COLOR,
            zStrokeColor = DEFUALT_COLOR;
    private int
            zStrokeWidth,
            zCornerBR,
            zCornerTR,
            zCornerBL,
            zCornerTL,
            zPaddingT,
            zPaddingL,
            zPaddingR,
            zPaddingB;
    private Drawable zDrawable;
    //state pressed
    private int
            zPressedColor = DEFUALT_COLOR,
            zPressedStrokeColor = DEFUALT_COLOR;
    private int
            zPressedStrokeWidth,
            zPressedCornerBR,
            zPressedCornerTR,
            zPressedCornerBL,
            zPressedCornerTL,
            zPressedPaddingT,
            zPressedPaddingL,
            zPressedPaddingR,
            zPressedPaddingB;
    private Drawable zPressedDrawable;
    //state selected
    private int
            zSelectedColor = DEFUALT_COLOR,
            zSelectedStrokeColor = DEFUALT_COLOR;
    private int
            zSelectedStrokeWidth,
            zSelectedCornerBR,
            zSelectedCornerTR,
            zSelectedCornerBL,
            zSelectedCornerTL,
            zSelectedPaddingT,
            zSelectedPaddingL,
            zSelectedPaddingR,
            zSelectedPaddingB;
    private Drawable zSelectedDrawable;
    //state unabele
    private int
            zUnableColor = DEFUALT_COLOR,
            zUnableStrokeColor = DEFUALT_COLOR;
    private int
            zUnableStrokeWidth,
            zUnableCornerBR,
            zUnableCornerTR,
            zUnableCornerBL,
            zUnableCornerTL,
            zUnablePaddingT,
            zUnablePaddingL,
            zUnablePaddingR,
            zUnablePaddingB;
    private Drawable zUnableDrawable;

    public ZRelativeLayout(Context context) {
        this(context, null);
    }

    public ZRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //注意：里面的“-”号，当XML的设定是false时，就需要使用资源符号的负值来设定。
        //按下时的状态
        initAttrs(context, attrs);
    }




    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setEnabled(true);
        }
    }


    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            setSelected(false);
        }
    }




    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ZView);
        zType = array.getInt(R.styleable.ZView_zType, zType);
        switch (zType) {
            case TYPE_COLOR:
                //state defualt
                zColor = array.getColor(R.styleable.ZView_zColor, zColor);
                zStrokeColor = array.getColor(R.styleable.ZView_zStrokeColor, zStrokeColor);
                zStrokeWidth = array.getDimensionPixelOffset(R.styleable.ZView_zStrokeWidth, zStrokeWidth);
                zCornerBL = array.getDimensionPixelOffset(R.styleable.ZView_zCornerBL, zCornerBL);
                zCornerBR = array.getDimensionPixelOffset(R.styleable.ZView_zCornerBR, zCornerBR);
                zCornerTL = array.getDimensionPixelOffset(R.styleable.ZView_zCornerTL, zCornerTL);
                zCornerTR = array.getDimensionPixelOffset(R.styleable.ZView_zCornerTR, zCornerTR);
                zPaddingB = array.getDimensionPixelOffset(R.styleable.ZView_zPaddingB, zPaddingB);
                zPaddingT = array.getDimensionPixelOffset(R.styleable.ZView_zPaddingT, zPaddingT);
                zPaddingL = array.getDimensionPixelOffset(R.styleable.ZView_zPaddingL, zPaddingL);
                zPaddingR = array.getDimensionPixelOffset(R.styleable.ZView_zPaddingR, zPaddingR);
                //state pressed
                zPressedColor = array.getColor(R.styleable.ZView_zPressedColor, zPressedColor);
                zPressedStrokeColor = array.getColor(R.styleable.ZView_zPressedStrokeColor, zPressedStrokeColor);
                zPressedStrokeWidth = array.getDimensionPixelOffset(R.styleable.ZView_zPressedStrokeWidth, zPressedStrokeWidth);
                zPressedCornerBL = array.getDimensionPixelOffset(R.styleable.ZView_zPressedCornerBL, zPressedCornerBL);
                zPressedCornerBR = array.getDimensionPixelOffset(R.styleable.ZView_zPressedCornerBR, zPressedCornerBR);
                zPressedCornerTL = array.getDimensionPixelOffset(R.styleable.ZView_zPressedCornerTL, zPressedCornerTL);
                zPressedCornerTR = array.getDimensionPixelOffset(R.styleable.ZView_zPressedCornerTR, zPressedCornerTR);
                zPressedPaddingB = array.getDimensionPixelOffset(R.styleable.ZView_zPressedPaddingB, zPressedPaddingB);
                zPressedPaddingT = array.getDimensionPixelOffset(R.styleable.ZView_zPressedPaddingT, zPressedPaddingT);
                zPressedPaddingL = array.getDimensionPixelOffset(R.styleable.ZView_zPressedPaddingL, zPressedPaddingL);
                zPressedPaddingR = array.getDimensionPixelOffset(R.styleable.ZView_zPressedPaddingR, zPressedPaddingR);
                //state selected
                zSelectedColor = array.getColor(R.styleable.ZView_zSelectedColor, zSelectedColor);
                zSelectedStrokeColor = array.getColor(R.styleable.ZView_zSelectedStrokeColor, zSelectedStrokeColor);
                zSelectedStrokeWidth = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedStrokeWidth, zSelectedStrokeWidth);
                zSelectedCornerBL = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedCornerBL, zSelectedCornerBL);
                zSelectedCornerBR = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedCornerBR, zSelectedCornerBR);
                zSelectedCornerTL = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedCornerTL, zSelectedCornerTL);
                zSelectedCornerTR = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedCornerTR, zSelectedCornerTR);
                zSelectedPaddingB = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedPaddingB, zSelectedPaddingB);
                zSelectedPaddingT = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedPaddingT, zSelectedPaddingT);
                zSelectedPaddingL = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedPaddingL, zSelectedPaddingL);
                zSelectedPaddingR = array.getDimensionPixelOffset(R.styleable.ZView_zSelectedPaddingR, zSelectedPaddingR);
                //state unable
                zUnableColor = array.getColor(R.styleable.ZView_zUnableColor, zUnableColor);
                zUnableStrokeColor = array.getColor(R.styleable.ZView_zUnableStrokeColor, zUnableStrokeColor);
                zUnableStrokeWidth = array.getDimensionPixelOffset(R.styleable.ZView_zUnableStrokeWidth, zUnableStrokeWidth);
                zUnableCornerBL = array.getDimensionPixelOffset(R.styleable.ZView_zUnableCornerBL, zUnableCornerBL);
                zUnableCornerBR = array.getDimensionPixelOffset(R.styleable.ZView_zUnableCornerBR, zUnableCornerBR);
                zUnableCornerTL = array.getDimensionPixelOffset(R.styleable.ZView_zUnableCornerTL, zUnableCornerTL);
                zUnableCornerTR = array.getDimensionPixelOffset(R.styleable.ZView_zUnableCornerTR, zUnableCornerTR);
                zUnablePaddingB = array.getDimensionPixelOffset(R.styleable.ZView_zUnablePaddingB, zUnablePaddingB);
                zUnablePaddingT = array.getDimensionPixelOffset(R.styleable.ZView_zUnablePaddingT, zUnablePaddingT);
                zUnablePaddingL = array.getDimensionPixelOffset(R.styleable.ZView_zUnablePaddingL, zUnablePaddingL);
                zUnablePaddingR = array.getDimensionPixelOffset(R.styleable.ZView_zUnablePaddingR, zUnablePaddingR);
                initStateList(getDefaultLayerDrawable(), getPressedLayerDrawable(), getSelectedLayerDrawable(), getUnableLayerDrawable());
                break;
            case TYPE_DRAWABLE:
                zDrawable = array.getDrawable(R.styleable.ZView_zDrawable);
                zPressedDrawable = array.getDrawable(R.styleable.ZView_zPressedDrawable);
                zSelectedDrawable = array.getDrawable(R.styleable.ZView_zSelectedDrawable);
                zUnableDrawable = array.getDrawable(R.styleable.ZView_zUnableDrawable);
                initStateList(zDrawable, zPressedDrawable, zSelectedDrawable, zUnableDrawable);
                break;
        }
        array.recycle();

    }

    @NonNull
    private LayerDrawable getUnableLayerDrawable() {
        //unable_ state
        GradientDrawable unable_drawable = new GradientDrawable();
        unable_drawable.setColor(zUnableColor);
        unable_drawable.setStroke(zUnableStrokeWidth, zUnableStrokeColor);
        float[] unable_radii = new float[8];
        unable_radii[0] = unable_radii[1] = zUnableCornerTL;
        unable_radii[2] = unable_radii[3] = zUnableCornerTR;
        unable_radii[4] = unable_radii[5] = zUnableCornerBR;
        unable_radii[6] = unable_radii[7] = zUnableCornerBL;
        unable_drawable.setCornerRadii(unable_radii);
        LayerDrawable unable_layerDrawable = new LayerDrawable(new GradientDrawable[]{unable_drawable});
        unable_layerDrawable.setLayerInset(0, zUnablePaddingL, zUnablePaddingT, zUnablePaddingR, zUnablePaddingB);
        return unable_layerDrawable;
    }

    @NonNull
    private LayerDrawable getSelectedLayerDrawable() {
        //selected_ state
        GradientDrawable selected_drawable = new GradientDrawable();
        selected_drawable.setColor(zSelectedColor);
        selected_drawable.setStroke(zSelectedStrokeWidth, zSelectedStrokeColor);
        float[] selected_radii = new float[8];
        selected_radii[0] = selected_radii[1] = zSelectedCornerTL;
        selected_radii[2] = selected_radii[3] = zSelectedCornerTR;
        selected_radii[4] = selected_radii[5] = zSelectedCornerBR;
        selected_radii[6] = selected_radii[7] = zSelectedCornerBL;
        selected_drawable.setCornerRadii(selected_radii);
        LayerDrawable selected_layerDrawable = new LayerDrawable(new GradientDrawable[]{selected_drawable});
        selected_layerDrawable.setLayerInset(0, zSelectedPaddingL, zSelectedPaddingT, zSelectedPaddingR, zSelectedPaddingB);
        return selected_layerDrawable;
    }

    @NonNull
    private LayerDrawable getPressedLayerDrawable() {
        //pressed state
        GradientDrawable pressed_drawable = new GradientDrawable();
        pressed_drawable.setColor(zPressedColor);
        pressed_drawable.setStroke(zPressedStrokeWidth, zPressedStrokeColor);
        float[] pressed_radii = new float[8];
        pressed_radii[0] = pressed_radii[1] = zPressedCornerTL;
        pressed_radii[2] = pressed_radii[3] = zPressedCornerTR;
        pressed_radii[4] = pressed_radii[5] = zPressedCornerBR;
        pressed_radii[6] = pressed_radii[7] = zPressedCornerBL;
        pressed_drawable.setCornerRadii(pressed_radii);
        LayerDrawable pressed_layerDrawable = new LayerDrawable(new GradientDrawable[]{pressed_drawable});
        pressed_layerDrawable.setLayerInset(0, zPressedPaddingL, zPressedPaddingT, zPressedPaddingR, zPressedPaddingB);
        return pressed_layerDrawable;
    }

    @NonNull
    private LayerDrawable getDefaultLayerDrawable() {
        //default state
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(zColor);
        drawable.setStroke(zStrokeWidth, zStrokeColor);
        float[] radii = new float[8];
        radii[0] = radii[1] = zCornerTL;
        radii[2] = radii[3] = zCornerTR;
        radii[4] = radii[5] = zCornerBR;
        radii[6] = radii[7] = zCornerBL;
        drawable.setCornerRadii(radii);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{drawable});
        layerDrawable.setLayerInset(0, zPaddingL, zPaddingT, zPaddingR, zPaddingB);
        return layerDrawable;
    }

    private void initStateList(Drawable layerDrawable, Drawable pressed_layerDrawable, Drawable selected_layerDrawable, Drawable unable_layerDrawable) {
        StateListDrawable drawableList = new StateListDrawable();
        drawableList.addState(new int[]{android.R.attr.state_pressed}, pressed_layerDrawable);
        drawableList.addState(new int[]{android.R.attr.state_selected}, selected_layerDrawable);
        drawableList.addState(new int[]{-android.R.attr.state_enabled}, unable_layerDrawable);
        drawableList.addState(new int[]{}, layerDrawable);//给一个空值就是默认状态,默认状态必须放在最后,否则不起效果
        setBackgroundDrawable(drawableList);
    }


}
