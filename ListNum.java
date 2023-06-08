class Node {
    private int info;
    private Node link;
    public Node(int info,Node link)
   {
       this.info=info;
       this.link=link;
    }
    public Node(int info)
    {
        this(info,null);
    }
    public Node()
    {
        this(0,null);
    }
    public int getInfo() {
	return this.info;
    }
    public Node getLink() {
        return this.link;
    }
    public void setInfo(int info) 
    {
	this.info=info;
    }
    public void setLink(Node link) {
        this.link = link;
    }
    public String toString() {
	return ""+this.info;
    }
}
public class ListNum {

    private Node head=null;
    public ListNum()
    {
    } 
    public void addNode(int newInfo) {
    	Node newNode = new Node(newInfo);
		newNode.setLink(head);	
		head = newNode;
    }
    public String toString() {
        Node trav=head;
	String str="";
	while (trav!=null) {			
		str=str.concat(trav.toString());
		//str=str.concat(""+trav.getInfo());
                trav=trav.getLink();
		if(trav!=null)
                    str=str.concat(" | ");		
	}
	return str;
    }
    public int travers(){
        Node trav = head ;
        int cnt = 0 ;
        while(trav!=null){
            cnt ++ ;
            trav = trav.getLink() ;
        }
        return cnt ;
    }
    public void addback(int sth){
        Node trav1 = head ;
        Node trav2 = head ;
        Node trav = new Node (sth) ;
        while(trav1 != null){
            trav2 = trav1 ;
            trav1 = trav1.getLink() ;
        }
        if(trav1 != trav2){
            
            trav2.setLink(trav);
        }
        else{
            head = trav ;
        }
    }
    public void addsort(int num){
        Node trav1 = head ;
        Node trav2 = head ;
        Node trav = new Node (num) ;
        while(trav1 != null && trav1.getInfo() < trav.getInfo()){
            trav2 = trav1 ;
            trav1 = trav1.getLink() ;
        }
        trav.setLink(trav1);
        if(trav1 != trav2){
            trav2.setLink(trav);
        }
        else{
            head = trav ;
        }
    }
    public void delhead(){
        Node delNode = head ;
        if(head != null) head = head.getLink() ;
    }
    public void deltail(){
        Node trav1 = head ;
        Node trav2 = head ;
        while(trav1 != null && trav1.getLink() != null){
            trav2 = trav1 ;
            trav1 = trav1.getLink() ;
        }
        Node delNode = trav1 ;
        if(trav2 != null){
            trav2.setLink(null);
            if(delNode == head){
                head = null ;
            }
        }
    }
    public void serch (int sth){
        Node trav = head ;
        int cnt = 1 ;
        while(trav != null && trav.getInfo() != sth){
            trav = trav.getLink() ;
            cnt ++ ;
        }
        if(trav != null){
            System.out.println(cnt);
        }
        else{
            System.out.println("Not");
        }
    }
    public void del(int sth){
        Node trav1 = head ;
        Node trav2 = head ;
        while(trav1 != null){
            if(trav1.getInfo() == sth){
                Node delNode = trav1 ;
                if(trav1 != head){
                    trav2.setLink(trav1.getLink());
                }
                else{
                    head = trav1.getLink() ;
                }
            }
            else{
                trav2 = trav1 ;               
            }
            trav1 = trav1.getLink() ;
        }
    }
    
    public static void main(String[] args) {
        ListNum listNum1=new ListNum();
        listNum1.addNode(10);
        listNum1.addNode(20);
        listNum1.addNode(30);          
        listNum1.addback(40);
        System.out.println(listNum1.travers());
        System.out.println(listNum1);
        listNum1.addsort(25);
        System.out.println(listNum1);
        listNum1.delhead();
        System.out.println(listNum1);
        listNum1.deltail();
        System.out.println(listNum1);
        listNum1.serch(20);
        listNum1.del(20);
        System.out.println(listNum1);
    }    
}