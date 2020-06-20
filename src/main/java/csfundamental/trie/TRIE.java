package csfundamental.trie;

import java.util.*;

public class TRIE {
    TrieNode root = null;

    public static void main(String[] ar) {
        TRIE trie = new TRIE();
        String[] strings = {"cat", "rat", "car", "ram", "cab", "carefree"};
        trie.insertWord(strings[0]);
        trie.insertWord(strings[1]);
        trie.insertWord(strings[2]);
        trie.insertWord(strings[3]);
        trie.insertWord(strings[4]);
        trie.insertWord(strings[5]);
        System.out.println("*********************");
        boolean isExist = trie.search("caaa");
        System.out.println(isExist);
        System.out.println("*********************");
        System.out.println(trie.autoSuggest("ca"));
    }

    public void insertWord(String key) {
        if (root == null) {
            root = new TrieNode('/');
        }
        TrieNode temp = root;
        for (int x = 0; x < key.length(); x++) {
            if (temp.trieNodeMap.get(key.charAt(x)) == null) {
                TrieNode newNode = new TrieNode(key.charAt(x));
                temp.trieNodeMap.put(key.charAt(x), newNode);
                temp = newNode;
            } else {
                temp = temp.trieNodeMap.get(key.charAt(x));
            }
        }
        temp.isWord = true;
    }

    public boolean search(String key) {
        TrieNode temp = root;
        for (int x = 0; x < key.length(); x++) {
            if (temp.trieNodeMap.get(key.charAt(x)) == null) {
                return false;
            } else {
                temp = temp.trieNodeMap.get(key.charAt(x));
                if (temp.isWord) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<String> autoSuggest(String key) {
        TrieNode temp = root;

        //find the node till the key matches
        for (int x = 0; x < key.length(); x++) {
            if (temp.trieNodeMap.get(key.charAt(x)) == null) {
                return new HashSet<>();
            } else {
                temp = temp.trieNodeMap.get(key.charAt(x));
            }
        }

        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(temp);

        Set<String> set = new HashSet<>();
        //once we find the node then we need to add each of the node to the key
        while (!queue.isEmpty()) {
            TrieNode node = queue.peek();
            if(node.isWord) {
                set.add(key + node.c);
            }
            for (Map.Entry<Character, TrieNode> entry : node.trieNodeMap.entrySet()) {
                    queue.add(entry.getValue());
            }
            queue.remove();
        }


        return set;
    }

}

class TrieNode {
    Map<Character, TrieNode> trieNodeMap = new HashMap<>();
    Character c;
    boolean isWord = false;
    TrieNode(Character c){
        this.c = c;
    }
}
