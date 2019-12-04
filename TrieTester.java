import com.nitin.utils.Trie;

class TrieTester{
    public static void main(String args[]){
        Trie dict=new Trie();
        dict.insert("app");
        dict.insert("apple");
        dict.insert("beer");

        dict.insert("add");
        dict.insert("jam");
        dict.insert("rental");

        dict.insert("apostle");
        dict.insert("apostrophe");

        System.out.println(dict.search("apple"));
        System.out.println(dict.startsWith("ma"));
        System.out.println(dict.startsWith("so"));
        System.out.println(dict.search("nitin"));
        System.out.println(dict.search("manuel"));

        System.out.println(dict.search("university"));
    }
}