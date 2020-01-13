package com.vishalguptahmh.highlighttextview;

public interface HighlightMethods {
     HighLightWordBuilder startWith(String startWith);
     HighLightWordBuilder endWith(String endWith);
     HighLightWordBuilder boldText();
     HighLightWordBuilder highlighNumbers();
//     HighLightWordBuilder setstrikeWithColor(String color);
     HighLightWordBuilder setStrike();
    HighLightWordBuilder setTextColor(String color);
}
