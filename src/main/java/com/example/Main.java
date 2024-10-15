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
        Scanner input = new Scanner(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        int scelta;

        String stringa;
        do {
            menu();
            String StrScelta = scanner.nextLine();
            scelta = Integer.parseInt(StrScelta);
            switch (scelta) {
                case 0:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Server chiuso");
                    break;
                case 1:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Inserisci una stringa: ");
                    stringa = scanner.nextLine();
                    out.writeBytes(stringa + "\n");
                    break;
                case 2:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Inserisci una stringa: ");
                    stringa = scanner.nextLine();
                    out.writeBytes(stringa + "\n");
                    break;
                case 3:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Inserisci una stringa: ");
                    stringa = scanner.nextLine();
                    out.writeBytes(stringa + "\n");
                    break;
                case 4:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Inserisci una stringa: ");
                    stringa = scanner.nextLine();
                    out.writeBytes(stringa + "\n");
                    break;
            
                default:
                    out.writeBytes(StrScelta + "\n");
                    System.out.println("Scegli per bene");
                    break;
            }

            String risposta = input.nextLine();
            System.out.println("Risposta del server: " + risposta);

        } while (scelta != 0);
        
        out.close();
        input.close();
        scanner.close();
        s.close();
    }

    public static void menu(){
        System.out.println("\n- - - BENVENUTO - - -");
        System.out.println("Potrai inviare messaggi al server e tramite diversi comandi sceglierai la sua risposta");
        System.out.println("1)Ti verrà restituita la stringa in maiuscolo");
        System.out.println("2)Ti verrà restituita la stringa in minuscolo");
        System.out.println("3)Ti verrà restituita la stringa al contrario");
        System.out.println("4)Ti verrà restituita il numero di caratteri nella stirnga");
    }
}