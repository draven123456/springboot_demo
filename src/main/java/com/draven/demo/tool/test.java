package com.draven.demo.tool;


import com.github.houbb.word.checker.core.impl.EnWordChecker;
import com.github.houbb.word.checker.util.EnWordCheckers;
import com.github.houbb.word.checker.util.ZhWordCheckers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] arge) {
        // 英文
        final String text = "Procpess finished wirth exit coddde,fafafwef,sfsfa.sfsfa?hi";
        StringTokenizer st = new StringTokenizer(text," ,?.!:\"\"''\n#");
        List<String> wordList = new ArrayList<>();
        List<String> errorWordList = new ArrayList<>();
        while (st.hasMoreElements()) {
            wordList.add(st.nextToken());
        }
        for (String s:wordList){
            if (!EnWordCheckers.isCorrect(s)){
                if (!errorWordList.contains(s))
                errorWordList.add(s);
            }
        }
        System.out.println(errorWordList.toString());

    }
}
