package csfundamental.stacks;

public class TowerOfHanoi {

    public static void main(String[] ar) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        StackChar tower1 = new StackChar("Tower1"); //src
        StackChar tower2 = new StackChar("Tower2"); //destination
        StackChar tower3 = new StackChar("Tower3"); //aux
        tower1.push('A');
        tower1.push('B');
        tower1.push('C');
        towerOfHanoi.move(3,tower1,tower3,tower2);
        tower3.printStackItems();
    }
    public void move(int n , StackChar src, StackChar dest , StackChar aux) {
        if(n==1){
            Node node = src.pop();
            dest.push(node.ch);
            System.out.println(node.ch + " is moved from " + src.name + " to " + dest.name);
        } else {
            move(n-1,src,aux,dest);
            Node node = src.pop();
            dest.push(node.ch);
            System.out.println(n + " is moved from " + src.name + " to " + dest.name);
            move(n-1,aux,dest,src);
        }
    }
}
