/*
    NOME:           Esercizio 1
    DATA:           02-03-2023

    TRACCIA:
                    Utilizzando IntelliJ IDEA, creare un nuovo progetto Java,
                    con all’interno una classe denominata Esercitazione e un
                    main che effettui le seguenti operazioni:

                    • Creazione di un array di 10 interi
                    • Stampa del contenuto dell’array
                    • Calcolo del massimo valore nell’array
                    • Calcolo del minimo valore nell’array
                    • Calcolo della media dei valori nell’array
                    • Ordinamento dell’array in ordine crescente
                    • Ordinamento dell’array in ordine decrescente
                    • Stampa di tutti i numeri primi all’interno dell’array
 */

import java.util.Scanner;

public class Esercitazione {
    public static void main(String[] args) {
        int max = 0; int min; int somma = 0;
        int[] array = new int[10];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < array.length; i++)
            array[i] = sc.nextInt();                //Riempio l'array.

        int[] arrayCrescente = new int[10];         //Array di supporto.
        int[] arrayDecrescente = new int[10];

        for (int i = 0; i < array.length; i++)      //Configuro gli array.
        {
            arrayCrescente[i] = array[i];
            arrayDecrescente[i] = array[i];
        }

        System.out.println("Array:");

        for(var i : array)                          //Stampo gli array correnti.
            System.out.println(i);

        min = max = array[0];                       //Inizializzo la var di supporto
                                                    //al primo val dell'array.

        for (var i : array)                         //Per ogni elemento di array...
        {
            if (i > max)                            //se è maggiore di max...
                max = i;                            //allora è il nuovo max.

            if (i < min)                            //se è minore di min...
                min = i;                            //allora è il nuovo min.

            somma += i;                             //Sommiamo i valori tra di loro.
        }

                                                                    //Algoritmo Bubble Sort Crescente.
        for (int i = 0; i < (array.length - 1); i++)                //Sia i index tra 0 e il penultimo elem...
            for (int j = 0; j < (array.length - i - 1); j++)        //Sia j index tra 0 e il (lunghezza - i - 1) elem...
                if (arrayCrescente[j] > arrayCrescente[j + 1])      //Se a[i] > a[j]:
                {
                    int temp = arrayCrescente[j];                   //Mettiamo da parte una var temp uguale ad a[j].
                    arrayCrescente[j] = arrayCrescente[j + 1];      //a[j + 1] e...
                    arrayCrescente[j + 1] = temp;                   //a[j] si scambiano di posto.
                }
                                                                    //Algoritmo Bubble Sort Decrescente.
        for (int i = 0; i < (array.length - 1); i++)
            for (int j = 0; j < (array.length - i - 1); j++)
                if (arrayDecrescente[j] < arrayDecrescente[j + 1])  //L'unica differenza sta nel segno.
                {
                    int temp = arrayDecrescente[j];
                    arrayDecrescente[j] = arrayDecrescente[j + 1];
                    arrayDecrescente[j + 1] = temp;
                }

    System.out.println("\nMIN: " + min + " MAX: " + max);           //Stampo min e max.
    System.out.println("MEDIA: " + (somma / array.length));         //Stampo la media.
    System.out.println("\nNumeri primi:");

    for (var i : array)
    {
        boolean primo = true;
        for (int j = 2; j < i; j++)     //Per ogni val tra 2 ed elem...
            if (i % j == 0)             //controlla se sono divisibili.
                primo = false;
        if (primo)                      //Stampa il val se è primo.
            System.out.println(i);
    }

    System.out.println("\nArray Ordinato Crescente:");

    for(var i : arrayCrescente)
        System.out.println(i);

    System.out.println("\nArray Ordinato Decrescente:");

    for(var i : arrayDecrescente)
        System.out.println(i);
    }
}
