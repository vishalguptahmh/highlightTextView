package com.vishalguptahmh.highlighttextview;

import android.util.Log;

public  class HighLightWordBuilder implements HighlightMethods{
    String TAG=getClass().getSimpleName();
    String textcolor=null;
    String strikeColor="FF0000";
    boolean strikethrough=false;
    boolean textbold=false;
    boolean highlightNumber=false;
    String startwith="";
    String endWith="";
    static boolean debugging=false;
    StringBuilder stringBuilder=new StringBuilder();
    StringBuilder stringBuilderend=new StringBuilder();

    public HighLightWordBuilder reset(){
        strikethrough=false;
        textbold=false;
        highlightNumber=false;
        startwith="";
        endWith="";
        textcolor=null;
        stringBuilder=new StringBuilder();
        stringBuilderend=new StringBuilder();
        return this;
    }

    public HighLightWordBuilder(){ }
    public static HighLightWordBuilder getInstance(){
        return new  HighLightWordBuilder();
    }
    public HighLightWordBuilder build(){
        if(startwith!=null){
            stringBuilder.append(startwith);
        }
        //strike
        if(strikethrough){
            stringBuilder.append("<s>");
            stringBuilderend.append("</s>");
        }
        //bold
        if(textbold){
            stringBuilder.append("<b>");
            stringBuilderend.append("</b>");
        }
        // color
        if(textcolor!=null){
            stringBuilder.append("<font  color=\"");
            stringBuilder.append(textcolor);
            stringBuilder.append("\" >");
            stringBuilderend.append("</font>");
        }
        //end
        if(endWith!=null){
            stringBuilderend.append(endWith);
        }
        startwith=stringBuilder.toString();
        endWith=stringBuilderend.toString();
        Log.d(TAG, "build: startWith: "+startwith+"\nmainString: \nendwith:-> "+endWith);
        return this;
    }


    @Override
    public HighLightWordBuilder startWith(String startWith) {
        this.startwith=startWith;
        return this;
    }

    @Override
    public HighLightWordBuilder endWith(String endWith) {
        this.endWith=endWith;
        return this;
    }

    @Override
    public HighLightWordBuilder boldText() {
        textbold=true;
        return this;
    }

    @Override
    public HighLightWordBuilder highlighNumbers() {
        highlightNumber=true;
        return this;
    }

    @Override
    public HighLightWordBuilder setStrike() {
        strikethrough=true;
        return this;
    }

    @Override
    public HighLightWordBuilder setTextColor(String color) {
        textcolor=color;
        return this;
    }
    private HighLightWordBuilder setstrikeWithColor(String color) {
        strikethrough=true;
        strikeColor=color==null?"#000":color;
        return this;
    }

    public static boolean isDebugging() {
        return debugging;
    }

    public static void setDebugging(boolean debugging) {
        HighLightWordBuilder.debugging = debugging;
    }
}