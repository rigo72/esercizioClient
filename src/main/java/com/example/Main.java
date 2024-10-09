package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito");
        Socket mySocket = new Socket("172.21.228.134",3645);
        System.out.println("Il client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        String outputString;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Inserisci la stringa: ");
            outputString = sc.nextLine();
            out.writeBytes(outputString + "\n");
            String stringInput = in.readLine();
            System.out.println("String ricevuta: " + stringInput);
        }while(outputString != "!");
        sc.close();
        mySocket.close();
    }
}