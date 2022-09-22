package com.bharath.skills.main;

class TrieNode{
    
    TrieNode[] next = new TrieNode[26];
    int count = 0;
    boolean isEnd;
}

class Trie{
    
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void add(String s){
        
        TrieNode cur = root;
        
        for(char ch: s.toCharArray()){
            
            if(cur.next[ch-'a'] == null)
                cur.next[ch-'a'] = new TrieNode();
            
            cur = cur.next[ch-'a'];
            cur.count++;
        }
        
        cur.isEnd = true;
    }
    
    public int getCount(String s){
        
        int count = 0;
        
        TrieNode cur = root;
        
        for(char c: s.toCharArray()){
                       
            cur = cur.next[c-'a'];
            
            count += cur.count;
            
        }
        
        return count;
        
    }
}

public class SumPrefixScores {
    public int[] sumPrefixScores(String[] words) {
        
        Trie trie = new Trie();
        
        for(String w: words){
            trie.add(w);
        }
        
        int[] ans = new int[words.length];
        
        for(int i=0;i<words.length;i++){
            
            ans[i] = trie.getCount(words[i]);
        }
        
        return ans;
    
    }
}