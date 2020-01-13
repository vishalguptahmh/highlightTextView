package com.vishalguptahmh.highlighttextview;


import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

public class HighLightWord{
    String TAG = getClass().getSimpleName().toString();
    private String startWith = "";
    private String endWith = "";
    private String mainString;
    private String[] valueList;
    private boolean highLightNumber = false;
    static boolean enableDebuging=false;
    private boolean strike=false;
    private static boolean debugging=false;
    public static void setDebuging(boolean debug){
        debugging=debug;
    }

    public HighLightWord(HighLightWordBuilder builder){
        startWith=builder.startwith;
        endWith=builder.endWith;
        highLightNumber=builder.highlightNumber;
        strike=builder.strikethrough;
    }

    public HighLightWord mainStringToHighLight(String string) {
        this.mainString = string;
        return this;
    }

    public HighLightWord wordsToHighlight(String... valueList) {
        this.valueList = valueList;
        return this;
    }

    public Spanned build() {
        if (mainString != null && mainString.length() > 0 && valueList != null && valueList.length > 0) {
            String[] stringList = mainString.split(" ");
            for (int i = 0; i < stringList.length; i++) {
                for (int j = 0; j < valueList.length; j++) {
                    if (valueList[j] != null && valueList[j].length() > 0 && stringList[i] != null && stringList[i].length() > 0) {
                        if (stringList[i].toLowerCase().contains(valueList[j].toLowerCase())) {
                            stringList[i]=stringList[i].replaceAll(stringList[i],startWith+stringList[i]+endWith);
                        }
                        if (highLightNumber) {
                            Log.d(TAG, "build: hightlightnubmer:"+highLightNumber);
                            if (TextUtils.isDigitsOnly(stringList[i])) {
                                stringList[i] = stringList[i].replaceAll(stringList[i], startWith + stringList[i] + endWith);
                            }
                        }
                    }
                }
            }
            mainString = Arrays.toString(stringList);
            mainString = mainString.replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
           if(debugging){
               Log.d(TAG, "build: " + mainString);
           }
        }
        return Html.fromHtml(mainString);
    }
}
