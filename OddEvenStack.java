
import java.util.Random;

class Node {

    private int info;
    private Node link = null;

    public Node(int info, Node link) {
        this.info = info;
        this.link = link;
    }

    public Node(int info) {
        this(info, null);
    }

    public Node() {
        this(0, null);
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getLink() {
        return this.link;
    }

    public void setLink(Node node) {
        this.link = node;
    }
}

class Stack {

    private int stackSize = 0;
    private Node stackTop = null;

    public Stack() {
        stackTop = null;
    }

    public void initializeStack() {
        stackTop = null;
    }
    public void push(int newItem){
        Node newNode = new Node(newItem) ;
        newNode.setLink(stackTop);
        stackTop = newNode ;
        stackSize ++ ;
    }
    public int peek()throws Exception{
        if(isEmptyStack()){
            throw new Exception("StackUnderflow") ;           
        }
        return stackTop.getInfo() ;
    }
    public int pop()throws Exception{
        int iteminfo ;
        if(isEmptyStack()){
            throw new Exception("StackUnderflow") ;
        }
        iteminfo = stackTop.getInfo() ;
        stackTop = stackTop.getLink() ;
        stackSize -- ;
        return iteminfo ;
    }
    public boolean isEmptyStack() {
        return (stackTop == null);
    }

    public boolean isFullStack() {
        return false;
    }

    public int getSize() {
        return stackSize;
    }
}
class OddEvenStack{
    public static void main(String[] args) throws Exception {
        Stack stodd = new Stack () ;
        Stack steven = new Stack () ;
        Stack geteven = new Stack () ;
        Stack getodd = new Stack () ;
        Random rd = new Random() ;
        final int n = (rd.nextInt(11)+10);
        System.out.println("--- Random Numbers ["+n+"] ---");
        for(int i = 0 ; i < n ; i ++ ){
            int x = rd.nextInt(101) ;
            System.out.print(x+" ");
            if(x % 2 == 0){
                steven.push(x);
            }
            else{
                stodd.push(x);
            }
        }
        int sizeeven = steven.getSize();
        int sizeodd = stodd.getSize() ;
        System.out.println("");
        System.out.println("--- Even Stack ["+steven.getSize()+"] ---");
        for(int i = 0 ; i < sizeeven; i ++){
            System.out.print(steven.peek()+" ");
            geteven.push(steven.peek());
            steven.pop() ;
        }
        System.out.println("");
        System.out.println("--- Odd Stack ["+stodd.getSize()+"] ---");
        for(int i = 0 ; i < sizeodd ; i ++){
            System.out.print(stodd.peek()+" ");
            getodd.push(stodd.peek());
            stodd.pop() ;
        }
        for(int i = 0 ; i < n ; i ++ ){
            if(getodd.getSize() == 0 || geteven.getSize() == 0){
                break ;
            }
            if(getodd.peek() > geteven.peek()){
                geteven.pop() ;
            }
            else{
                getodd.pop() ;
            }
        }
        if(geteven.getSize() == 0){
            System.out.println("");
            System.out.println("===> Odd is the winner!");
        }
        else{
            System.out.println("");
            System.out.println("===> Even is the winner!");
        }
    }
}
