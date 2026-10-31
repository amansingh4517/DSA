package Trie;

class Node{
    Node[][] link = new Node[26] ;


    public void insert(char ch ){
        link[ch-'a'][0] = new Node();
    }

}

class trie{
    private Node root = Node();

    public void insert(char ch , Node node ){
        node.insert(ch);
    }

}

public class ImplementTrie2 {
    
}
