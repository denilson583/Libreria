package herencia;

public class Triangulo extends DosDimensiones{
    private String estilo;
    //Constructor
    public Triangulo(String s, double b, double h){
        
        setBase(b);
        setAltura(h);
        estilo=s;
    }
    public double area(){
        return getBase()*getAltura()/2;
    }
    public void mostrarEstilo(){
        System.out.println("Triangulo es: "+estilo);
    }
}
