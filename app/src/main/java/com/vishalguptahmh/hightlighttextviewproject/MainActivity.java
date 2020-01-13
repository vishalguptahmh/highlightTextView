package com.vishalguptahmh.hightlighttextviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;

import com.vishalguptahmh.highlighttextview.HighLightWord;
import com.vishalguptahmh.highlighttextview.HighLightWordBuilder;
import com.vishalguptahmh.highlighttextview.Highlight;
import com.vishalguptahmh.hightlighttextviewproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        String string = getResources().getString(R.string.hello_world);

        HighLightWordBuilder.setDebugging(true);
        HighLightWordBuilder builder = HighLightWordBuilder.getInstance().boldText().setTextColor("#000000").build();

        HighLightWord.setDebuging(true);
        HighLightWord highLightWord = new HighLightWord(builder).mainStringToHighLight(string).wordsToHighlight("world");
        binding.text1.setText(highLightWord.build());


        builder.reset().setTextColor("#ff0000").build();
        binding.text2.setText(new HighLightWord(builder).mainStringToHighLight(string).wordsToHighlight("world").build());


        builder.reset().setTextColor("#000000").setStrike().build();
        binding.text3.setText(new HighLightWord(builder).mainStringToHighLight(string).wordsToHighlight("world").build());

        builder.reset().highlighNumbers().setTextColor("#000000").build();
        binding.text4.setText(new HighLightWord(builder).mainStringToHighLight(string).wordsToHighlight("world").build());


    }

}
