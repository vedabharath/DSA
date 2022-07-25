package com.bharath.skills.patterns;

import java.util.*;

class Sentence
{
    public String sentence;
    public Map<Integer,WordToken> map = new HashMap<>();
    public Sentence(String plainText)
    {
        this.sentence = plainText;
    }

    public WordToken getWord(int index)
    {
        map.put(index,new WordToken());
        return map.get(index);

    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0;i< words.length;i++){
            String word = words[i];
            if(map.containsKey(i) && map.get(i).capitalize){
                sb.append(word.toUpperCase());
            }else sb.append(word);
            if(i < words.length-1) sb.append(" ");
        }
        return sb.toString();
    }

    class WordToken
    {
        public boolean capitalize;
    }
}

public class FlyWeight {

    public static void main(String[] args) {
        Sentence s = new Sentence("alpha beta a gamma[]");
        s.getWord(1).capitalize = true;
        System.out.println(s);
    }

}
