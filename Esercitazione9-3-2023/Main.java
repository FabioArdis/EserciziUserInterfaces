import java.util.Scanner;

public class Main {
    static Magazzino engine = new Magazzino();
    public static void main(String[] args) {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while(loop) {
            System.out.println("""
                    Menù principale:
                    1- Aggiungi prodotto
                    2- Rimuovi prodotto
                    3- Filtra per marca
                    4- Filtra per modello
                    5- Filtra per anno di produzione
                    6- Mostra tutti i prodotti
                    7- Ordina per prezzo crescente
                    8- Ordina per prezzo decrescente
                    0- Esci
                    """);
            String scelta = sc.nextLine();
            switch (scelta) {
                case "1" -> {
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modello: ");
                    String modello = sc.nextLine();
                    System.out.print("Anno di produzione: ");
                    int annoProd = sc.nextInt();
                    if(annoProd < 1900 || annoProd > 2050)
                    {
                        System.out.println("Anno non valido.");
                        break;
                    }
                    System.out.print("Prezzo: ");
                    double prezzo = sc.nextDouble();
                    if(prezzo < 0.0)
                    {
                        System.out.println("Prezzo non valido.");
                        break;
                    }
                    Prodotto newProd = new Prodotto(tipo, marca, modello, annoProd, prezzo);
                    if (engine.add(newProd))
                        System.out.println("Prodotto aggiunto con successo.");
                    else
                        System.out.println("Errore nell'aggiunta del prodotto.");

                }
                case "2" -> {
                    System.out.print("Inserire l'ID del prodotto da eliminare: ");
                    String id = sc.nextLine();
                    if (engine.remove(id))
                        System.out.println("Prodotto eliminato con successo.");
                    else
                        System.out.println("Prodotto non trovato\n\n");
                }
                case "3" -> {
                    System.out.print("Inserire la marca da filtrare: ");
                    String fMarca = sc.nextLine();
                    engine.filterMarca(fMarca);
                }
                case "4" -> {
                    System.out.print("Inserire il modello da filtrare: ");
                    String fModello = sc.nextLine();
                    engine.filterModello(fModello);
                }
                case "5" -> {
                    System.out.print("Inserire l'anno da filtrare: ");
                    int fAnno = sc.nextInt();
                    engine.filterAnno(fAnno);
                }
                case "6" -> engine.print();
                case "7" -> engine.ordinaCrescente();
                case "8" -> engine.ordinaDecrescente();
                case "2010" -> System.out.println("Beccato.");
                case "0" -> loop = false;
            }


        }
    }
}