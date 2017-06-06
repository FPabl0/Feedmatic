package com.lzro.feedmatic.Instructions;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pablofuentes on 5/6/17.
 */

public class Instructions {
    private boolean finishInst = false;
    private TextView textView;
    private ImageView imageView;
    private int imageResourceId;
    private boolean useImage = false;
    private CharSequence text = "";
    private int pageNumber = 1;
    public boolean INST_LAST = true;
    public boolean INST_NORMAL = false;

    private static final Instructions ourInstance = new Instructions();
    public static Instructions getInstance() {
        return ourInstance;
    }
    private Instructions() {
    }

    public void setTextView(TextView textView){
        this.textView = textView;
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    public void addBold(String s){
        text = TextUtils.concat(text, Html.fromHtml("<b>"+s+"</b><br>"));
    }

    // \u2022 esto se usa para poner una viñeta
    public void addNormal(String s){
        text = TextUtils.concat(text, s + "\n");
    }

    public void addImage(int imageResourceId){
        this.imageResourceId = imageResourceId;
        this.useImage = true;
    }
    public void commit(boolean last){
        this.textView.setText(text);
        if(this.useImage ==  true){
            this.imageView.setVisibility(View.VISIBLE);
            this.imageView.setBackgroundResource(this.imageResourceId);
            this.useImage = false;
        }else{
            this.imageView.setVisibility(View.INVISIBLE);
        }
        clear();
        setFinish(last);
    }

    public void clear(){
        this.text = "";
    }

    public int getPage(){
        return this.pageNumber;
    }

    public void setPage(int page){
        this.pageNumber = page;
    }

    private void setFinish(boolean b){
        this.finishInst = b;
    }

    public boolean isFinish(){
        return this.finishInst;
    }
}
