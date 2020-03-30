package data;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactoData DAO está el CRUD
 */
public class LibrosDatos {
    List<Libros> listaLibros = new ArrayList<Libros>();

    public List<Libros> list() {
        return listaLibros;
    }

    public void create(Libros d) {
        listaLibros.add(d);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(Libros d) {
        listaLibros.remove(d);
    }

    public void delete(int id) {
        boolean existe= false;
        for (Libros d : listaLibros) {
            System.out.println("Deleted:"+d.getId() + "\t" + d.getNombre());
            if (id == d.getId()) {
                try {
                    listaLibros.remove(d);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Contacto si exist e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Libros no existe");
        }
    }

}