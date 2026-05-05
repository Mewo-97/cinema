package core_and_data;
import java.util.*;
import java.io.*;
class node {
    String username;
    String password;
    node next;
}
class Linked_list {
    node head;
    node tail;
    void add(String username, String password) {
        node temp = new node();
        temp.username = username;
        temp.password = password;
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }
    void printlist() {
        node temp = head;
        while (temp != null) {
            System.out.println(temp.username + " " + temp.password);
            temp = temp.next;
        }
    }
}
public class Login {
    public Linked_list list = new Linked_list();

    public void fillLogin() {
        File u = new File("Book_ticket/core_and_data/users.txt");
        StringTokenizer st;
        try (Scanner sc = new Scanner(u)) {
            while (sc.hasNextLine()) {
                st = new StringTokenizer(sc.nextLine(), " : ");
                list.add(st.nextToken(), st.nextToken());
            }
        } catch (FileNotFoundException e) {
            System.err.println("users.txt not found: " + e.getMessage());
        }
    }
    public boolean checkLogin(String n, String p) {
        node temp = list.head;
        while (temp != null) {
            if (temp.username.equals(n) && temp.password.equals(p)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public boolean checkLogin(String n){
        node temp = list.head;
        while (temp != null) {
            if (temp.username.equals(n) ) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void login(Scanner sc){
        
        while(true){
        System.out.println("Enter username:");
        String n=sc.nextLine();
        System.out.println("Enter password:");
        String p=sc.nextLine();
        if(checkLogin(n,p)){
            System.out.println("welcome back "+n);
            break;
        }
        else{
            System.out.println("Invalid username or password. Please try again.");
            
        }
    }}
    public void create_account(Scanner sc){
        String n;
        try{
            String x=sc.nextLine();


        }
        catch(){
            System.out.println(e.getMessage());
        }
        while (true) {
            System.out.println("Enter username:");
            n = sc.nextLine().trim();
            if (n.isEmpty() ) {
                System.out.println("Username cannot be empty.");
                continue;
            }
            else if (checkLogin(n)) {
                System.out.println("Username already exists. Please choose a different username.");
                continue;
            }
            boolean valid = true;
            for (int i = 0; i < n.length(); i++) {
                if (!Character.isLetter(n.charAt(i))) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                System.out.println("Username must contain only letters.");
                continue;
            }
            break;
        }
        System.out.println("Enter password:");
        String p = sc.nextLine().trim();
        try {
            FileWriter fw = new FileWriter("Book_ticket/core_and_data/users.txt", true);
            fw.write(n + " : " + p + "\n");
            fw.close();
            list.add(n, p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
