import java.util.Vector;

public class Magazzino {
    Vector<Prodotto> inventario = new Vector<Prodotto>();
    int idCounter = 0;

    public boolean add(Prodotto p) {
        if(inventario.add(p)) {
            idCounter++;
            p.id = Integer.toString(idCounter);
            return true;
        } else
            return false;
    }

    public boolean remove(String newId) {
        for (var i : inventario) {
            if (i.id.equalsIgnoreCase(newId)) {
                inventario.remove(i);
                return true;
            }
        }
        return false;
    }

    public void filterMarca(String search)
    {
        for(var i : inventario) {
            if (i.marca.equalsIgnoreCase(search)) {
                System.out.println("ID: " + i.id + "\tTipo: " +
                        i.tipo + "\tMarca: " + i.marca + "\tModello: " +
                        i.modello + "\tAnno di produzione: " + i.annoProd +
                        "\tPrezzo: " + i.prezzo);
            }
        }
    }

    public void filterModello(String search)
    {
        for(var i : inventario) {
            if (i.modello.equalsIgnoreCase(search)) {
                System.out.println("ID: " + i.id + "\tTipo: " +
                        i.tipo + "\tMarca: " + i.marca + "\tModello: " +
                        i.modello + "\tAnno di produzione: " + i.annoProd +
                        "\tPrezzo: " + i.prezzo);
            }
        }
    }

    public void filterAnno(int anno)
    {
        for(var i : inventario) {
            if (i.annoProd == anno) {
                System.out.println("ID: " + i.id + "\tTipo: " +
                        i.tipo + "\tMarca: " + i.marca + "\tModello: " +
                        i.modello + "\tAnno di produzione: " + i.annoProd +
                        "\tPrezzo: " + i.prezzo);
            }
        }
    }

    public void print()
    {
        for(var i : inventario)
            System.out.println("ID: " + i.id + "\tTipo: " +
                    i.tipo + "\tMarca: " + i.marca + "\tModello: " +
                    i.modello + "\tAnno di produzione: " + i.annoProd +
                    "\tPrezzo: " + i.prezzo);
    }

    public void ordinaCrescente()
    {
        for(int i = 0; i < inventario.size() - 1; i++)
        {
            for (int j = 0; j < (inventario.size() - i - 1); j++)
            {
                if(inventario.get(j).prezzo > inventario.get(j + 1).prezzo)
                {
                    Prodotto temp = inventario.get(j);
                    inventario.set(j, inventario.get(j + 1));
                    inventario.set(j + 1, temp);
                }
            }
        }
    }

    public void ordinaDecrescente()
    {
        for(int i = 0; i < inventario.size() - 1; i++)
        {
            for (int j = 0; j < (inventario.size() - i - 1); j++)
            {
                if(inventario.get(j).prezzo < inventario.get(j + 1).prezzo)
                {
                    Prodotto temp = inventario.get(j);
                    inventario.set(j, inventario.get(j + 1));
                    inventario.set(j + 1, temp);
                }
            }
        }
    }

}
