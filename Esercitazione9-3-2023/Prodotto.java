public class Prodotto {
    String id;
    String tipo;
    String marca;
    String modello;
    int annoProd;
    double prezzo;

    public Prodotto(String tipo, String marca, String modello, int annoProd, double prezzo)
    {
        this.tipo = tipo; this.marca = marca; this.modello = modello;
        this.annoProd = annoProd; this.prezzo = prezzo;
    }
}
