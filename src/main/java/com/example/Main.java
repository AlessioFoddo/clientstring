package com.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Il client si è collegato");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa: ");
        Scanner input = new Scanner(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringa;
        do {
            menu();
            stringa = scanner.nextLine();
            out.writeBytes(stringa + "\n");

            if (input.hasNextLine()) {
                String risposta = input.nextLine();
                System.out.println("Risposta del server: " + risposta);
            }
        } while (!stringa.equals("!"));
        
        out.close();
        input.close();
        scanner.close();
        s.close();
    }

    public static void menu(){
        System.out.println("\n- - - BENVENUTO - - -");
        System.out.println("Potrai inviare messaggi al server e tramite diversi comandi sceglierai la sua risposta");
        System.out.println("1) '^', ti verrà restituita la stringa in maiuscolo");
        System.out.println("2) '-', ti verrà restituita la stringa in minuscolo");
        System.out.println("3) '<', ti verrà restituita la stringa al contrario");
        System.out.println("4) ':', ti verrà restituita il numero di caratteri nella stirnga");
    }
}