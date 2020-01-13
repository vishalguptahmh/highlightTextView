package com.vishalguptahmh.highlighttextview;


import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;

import java.util.Arrays;

public class Highlight {
        String TAG = getClass().getSimpleName().toString();
        String startWith = "";
        String endWith = "";
        String mainString;
        String[] valueList;
        boolean highLightNumber = false;


        public static Highlight getInstance() {
            return new Highlight();
        }

        public Highlight startWith(String startWith) {
            this.startWith = startWith;
            return this;
        }


        public Highlight setColor(String color) {
            this.startWith = startWith + "<font  color=\"" + color + "\" >";
            this.endWith = "</font>" + endWith;
            return this;
        }

        public Highlight boldText() {
            this.startWith = "<b>";
            this.endWith = "</b>";
            return this;
        }

        public Highlight endWith(String endWith) {
            this.endWith = endWith;
            return this;
        }

        public Highlight highLight(String string) {
            this.mainString = string;
            return this;
        }

        public Highlight toValues(String... valueList) {
            this.valueList = valueList;
            return this;
        }

        public Highlight highlighNumbers(boolean highlighNumbers) {
            this.highLightNumber = highlighNumbers;
            return this;
        }

        public Spanned build() {
            if (mainString != null && mainString.length() > 0 && valueList != null && valueList.length > 0) {
                String[] stringList = mainString.split(" ");
                for (int i = 0; i < stringList.length; i++) {

                    for (int j = 0; j < valueList.length; j++) {

                        if (valueList[j] != null && valueList[j].length() > 0 && stringList[i] != null && stringList[i].length() > 0) {

                            if (stringList[i].toLowerCase().contains(valueList[j].toLowerCase())) {
                                stringList[i] = stringList[i].replaceAll(stringList[i], startWith + stringList[i] + endWith);

                            }

                            if (highLightNumber) {
                                if (TextUtils.isDigitsOnly(stringList[i])) {
                                    stringList[i] = stringList[i].replaceAll(stringList[i], startWith + stringList[i] + endWith);
                                }

                            }
                        }

                    }
                }
                mainString = Arrays.toString(stringList);
                mainString = mainString.replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
                Log.d(TAG, "build: " + mainString);
            }


            return Html.fromHtml(mainString);
        }

    }
