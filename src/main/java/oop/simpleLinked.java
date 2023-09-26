package oop;


//add: 1. at the end; 2. at the start; 3. on index; (all done)
//delete: 1. on index; 2. at the start; 3. at the end; 4. on value;(all done)
//print all list; (done)
//get: 1. on index; 2. on value -> if(true) -> index/false; (all done)


class test {
    public static void main(String[] args) {
        simpleLinked l = new simpleLinked();
    }
}


public class simpleLinked {

    private Node head;

    private int index;

    simpleLinked() {this.index = 0; }

    public void setIndex(int index) {
        this.index = index;
    }
    ;
    public void setHead(Node head) {
        this.head = head;
    }


    public void addAtTheEnd(int date) {
        if (this.head == null) {
            Node node = new Node(date);
            this.head = node;
        } else {
            Node headNode = this.head;
            while (headNode.getNext() != null) {
                headNode = headNode.getNext();
            }
            Node newNode = new Node(date);
            headNode.setNext(newNode);
            this.index++;
        }
    }

    public void addAtTheStart(int date) {
        Node node = new Node(date);
        if (this.head == null) {
            this.head = node;
        } else {
            Node tempNode = this.head;
            this.head = node;
            this.head.setNext(tempNode);
        }
        this.index++;
    }
    ;
    public void addOnIndex(int index, int date) {
        if(index <= 0){
            addAtTheStart(date);
        }else if(index > this.index){
            addAtTheEnd(date);
        }else {

            Node newNode = new Node(date);
            Node node = this.head;
            Node prevNode = null;
            Node nextNode = null;
            int counter = 0;

            while(counter != index){
                prevNode = node;
                node = node.getNext();
                counter++;
            }
            nextNode = node.getNext();
            prevNode.setNext(newNode);
            newNode.setNext(node);
            this.index++;
        }
    }
    ;

    public void deleteFromTheStart(){
        if(this.head == null){
            return;
        }else if(this.head != null && this.head.getNext() == null){
            this.head = null;
        }else {
            Node newHeadNode = this.head.getNext();
            this.head = newHeadNode;
        }
        this.index--;
    };

    public void deleteFromTheEnd(){
        Node node = this.head;
        Node prevNode = node;
        if(this.head == null){
            return;
        }

        while(node.getNext() != null){
            prevNode = node;
            node = node.getNext();
        }
        if(prevNode.getNext() == null){
            this.head = null;
        }else {
            prevNode.setNext(null);
        }
        this.index--;
    };

    public void deleteOnIndex(int index){
//        System.out.println(this.index);
        if(index <= 0){
            deleteFromTheStart();
        }else if(index >= this.index){
            deleteFromTheEnd();
        }else {

            Node node = this.head;
            Node prevNode = null;
            Node nextNode = null;
            int counter = 0;

            while(counter != index){
                prevNode = node;
                node = node.getNext();
                counter++;
            }
            nextNode = node.getNext();
            prevNode.setNext(nextNode);
            this.index--;
        }
    };


    public void deleteOnValue(int date){
        if(this.head == null) {
            System.out.println("List is empty");
        } else if(!this.containsInTheList(date)){
                System.out.println("This list not contains you're number");
        }
        else{
            Node node = this.head;
            Node prevNode = null;
            while(node.getDate() != date){
                prevNode = node;
                node = node.getNext();
            }
            if(node.getDate() == this.head.getDate()){
                this.head = node.getNext();
            }else{
                prevNode.setNext(node.getNext());
            }
            this.index--;
        }
    };



    public void getOnTheIndex(int index) {
        int counter = 0;
        Node node = this.head;

        if (index > this.index || index < 0) {
            System.out.println("Index out of range");
            return;
        } else {
            while (counter != index) {
                node = node.getNext();
                counter++;
            }
        }
        System.out.println("Ineger: " + node.getDate() + " on the index " + index + ".");
    }

    public boolean containsInTheList(int date){
        Node node = this.head;
        while(node.getNext() != null){
            if(node.getDate() == date){
                return true;
            }
            node = node.getNext();
        }
        if(node.getDate() == date){
            return true;
        }
        return false;
    };

    @Override
    public String toString() {
        String allList = "";
        if (this.head == null) {
            allList+="null";
        } else {
            Node head = this.head;
            allList += head.getDate() + " => ";
            while (head.getNext() != null) {
                head = head.getNext();
                allList += head.getDate() + " => ";
            }
            allList += "null";
        }
        return allList;
    }


}


class Node {

    private int date;

    private Node next;

    public Node(int date) {
        this.date = date;
        this.next = null;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}