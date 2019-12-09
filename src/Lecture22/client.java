package Lecture22;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Trie trie=new Trie();
        trie.add("art");
        trie.add("arts");
        trie.add("bug");
        trie.add("boy");
        trie.add("sea");
        trie.add("seen");
        trie.add("see");
        
        trie.display();
        
        System.out.println(trie.search("art"));
        System.out.println(trie.search("artist"));
        
        trie.displayTree();
        trie.remove("arts");
        System.out.println("****************");
        trie.displayTree();
        trie.remove("art");
        System.out.println("******************");
        trie.displayTree();
	}

}
