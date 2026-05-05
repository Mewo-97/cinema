package core_and_data;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    Login L = new Login();
    L.fillLogin();
    L.login(sc);
    L.create_account(sc);
    sc.close();
    }
}
