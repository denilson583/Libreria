package data;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactoData DAO está el CRUD
 */
public class CuadernosDatos {
    List<Cuadernos> listaCuadernos = new ArrayList<Cuadernos>();

    public List<Cuadernos> list() {
        return listaCuadernos;
    }

    public void create(Cuadernos d) {
        listaCuadernos.add(d);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(Cuadernos d) {
        listaCuadernos.remove(d);
    }

    public void delete(int id) {
        boolean existe= false;
        for (Cuadernos d : listaCuadernos) {
            System.out.println("Deleted:"+d.getId() + "\t" + d.getNombre());
            if (id == d.getId()) {
                try {
                    listaCuadernos.remove(d);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Contacto si exist e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Cuadernos no existe");
        }
    }

}