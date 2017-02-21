package com.example.lzc.titlelayoutdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lzc.titlelayoutdemo.R;

/**
 * 类描述：自定义标题栏
 * 创建人：zz
 * 创建时间： 2017/2/21 15:02
 */


public class TitleLayout extends LinearLayout {
    public static final int LEFT_MENU = 0;         //左侧图标的编号
    public static final int TITLE_MENU = 1;        //标题栏Title的编号
    public static final int RIGHT_MENU = 2;        //右侧图标的编号
    private TextView textLeft;
    private TextView textRight;
    private TextView textTitle;
    private ImageView imageLeft;


    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context,attrs);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context,attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.title_layout);
        String leftMenu = array.getString(R.styleable.title_layout_left_textview);
        boolean leftImageShow = array.getBoolean(R.styleable.title_layout_left_image_show, false);      //左侧显示文本还是图片
        LayoutInflater.from(context).inflate(R.layout.activity_title,this);
        textLeft = ((TextView) findViewById(R.id.textview_back));
        textTitle = ((TextView) findViewById(R.id.textview_title));
        textRight = ((TextView) findViewById(R.id.textview_right));
        imageLeft = ((ImageView) findViewById(R.id.imageview_left));
        if(leftImageShow){
            imageLeft.setVisibility(VISIBLE);
            textLeft.setVisibility(GONE);
        }else{
            imageLeft.setVisibility(GONE);
            textLeft.setVisibility(VISIBLE);
        }

    }


    public void setOnClickListener(int targetView,OnClickListener clickListener){
        switch (targetView){
            case LEFT_MENU:
                if(textLeft.getVisibility() == VISIBLE){
                textLeft.setOnClickListener(clickListener);
                }else {
                    imageLeft.setOnClickListener(clickListener);
                }
                break;
            case RIGHT_MENU:
                textRight.setOnClickListener(clickListener);
                break;
            case TITLE_MENU:
                textTitle.setOnClickListener(clickListener);
                break;
        }

    }
    //左侧、右侧、头部相同，不再写相同的
    public void setLeftText(String leftMenuString){
        if(leftMenuString != null){
            textLeft.setText(leftMenuString);
        }
    }
}
