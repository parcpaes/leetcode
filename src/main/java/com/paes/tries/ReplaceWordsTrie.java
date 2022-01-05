package com.paes.tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWordsTrie {
    public class TrieNode{
        private HashMap<Character,TrieNode> children;
        boolean isEndWord;
        public TrieNode(){
            this.children = new HashMap<>();
            this.isEndWord=false;
        }
        public void markAsLeaf(){
            this.isEndWord = true;
        }
    }
    public class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode currentNode = this.root;
            for (char character : word.toCharArray()) {
                currentNode = currentNode.children.computeIfAbsent(character,(c)->new TrieNode());
            }
            currentNode.markAsLeaf();
        }
        public String find(String word){
            TrieNode currentNode = this.root;
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(c);
                TrieNode node = currentNode.children.get(c);
                if(node==null) return word;
                if(node.isEndWord) return sb.toString();
                currentNode = node;
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary)  trie.insert(word);

        StringBuilder sb =new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(trie.find(word));
            sb.append(' ');
        }
        return sb.toString().stripTrailing();
    }

    public static void main(String[] args) {
        ReplaceWordsTrie replace = new ReplaceWordsTrie();
        List<String> dictionary = Arrays.asList("cat","bat","rat","rot");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replace.replaceWords(dictionary,sentence));
    }
}
