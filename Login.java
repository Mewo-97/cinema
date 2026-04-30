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
        try {
            Scanner sc = new Scanner(u);
            while (sc.hasNextLine()) {
                st = new StringTokenizer(sc.nextLine(), " : ");
                list.add(st.nextToken(), st.nextToken());
            }
            list.printlist();
            sc.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
    public boolean checkLogin(String n, String p) {
        node temp = list.head;
        while (temp != null) {
            if (temp.username==n && temp.password==p) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
