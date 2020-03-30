import java.awt.*;
import javax.swing.*;

import javax.swing.table.*;
//importando paquetes
import data.Libros;
import data.LibrosDatos;
import data.Cuadernos;
import data.CuadernosDatos;
import herencia.Triangulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainClass extends JFrame {
    /**
     * Descripción de la clase
     */
    private static final long serialVersionUID = 1L;
    // CRUD Libros
    int libretaId = 0;
    LibrosDatos librosDatos = new LibrosDatos();
    String[] librosColumns = { "id ", "Nombre", "Tipo de libro","origen","autor","Precio" };
    String[][] librosMatris = new String[0][librosColumns.length];
    DefaultTableModel model = new DefaultTableModel(librosMatris, librosColumns);
    JTable librosTabla = new JTable(model);
    JScrollPane librosSP = new JScrollPane();
    // CRUD Libros End

    //Crud cuadernos
    int cuadernosId = 0;
    CuadernosDatos cuadernosDatos = new CuadernosDatos();
    String[] cuadernosColumns = { "id ", "Marca","origen","calidad","Precio" };
    String[][] cuadernosMatris = new String[0][cuadernosColumns.length];
    DefaultTableModel model2 = new DefaultTableModel(cuadernosMatris, cuadernosColumns);
    JTable cuadernosTabla = new JTable(model2);
    JScrollPane cuadernosSP = new JScrollPane();
    //Crud cuadernos end

    public MainClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        // Creando MenuBar y agregando items
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Insertar");
        JMenu m2 = new JMenu("Ayuda");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Insertar Libros");
        JMenuItem m12 = new JMenuItem("Insertar Cuadernos");
        JMenuItem m19 = new JMenuItem("Salir");

        // CRUD Libros
        JPanel LibrosPanel = new JPanel();
        LibrosPanel.setLayout(new BoxLayout(LibrosPanel, BoxLayout.Y_AXIS));
        JLabel libroLblNombre = new JLabel("Ingrese el Nombre");       
        JTextField libroTxtNombre = new JTextField();

        JLabel libroLblTipo = new JLabel("Ingrese el Tipo");       
        JTextField libroTxtTipo = new JTextField();

        JLabel libroLblOrigen = new JLabel("Ingrese el Origen");       
        JTextField libroTxtOrigen = new JTextField();


        JLabel libroLblAutor = new JLabel("Ingrese el Autor");       
        JTextField libroTxtAutor = new JTextField();

        JLabel libroLblPrecio = new JLabel("Ingrese el Precio");       
        JTextField libroTxtPrecio = new JTextField();
        
        JButton libretaBtnAdd = new JButton("Add");        
        JButton button;  
        
         
       
        button = new JButton("Remove");
                
        librosSP.setViewportView(librosTabla);
        LibrosPanel.add(libroLblNombre);
        LibrosPanel.add(libroTxtNombre);

        LibrosPanel.add(libroLblTipo);
        LibrosPanel.add(libroTxtTipo);

        LibrosPanel.add(libroLblOrigen);
        LibrosPanel.add(libroTxtOrigen);

        LibrosPanel.add(libroLblAutor);
        LibrosPanel.add(libroTxtAutor);

        LibrosPanel.add(libroLblPrecio);
        LibrosPanel.add(libroTxtPrecio);

        LibrosPanel.add(libretaBtnAdd);
        LibrosPanel.add(button);
        LibrosPanel.add(librosSP);
        

        libretaBtnAdd.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                libretaId++;
                Libros d = new Libros();
                d.setId(libretaId);
                d.setNombre(libroTxtNombre.getText());
                d.setTipoLibro(libroTxtTipo.getText());
                d.setOrigen(libroTxtOrigen.getText());
                d.setAutor(libroTxtAutor.getText());
                d.setPrecio(libroTxtPrecio.getText());
                librosDatos.create(d);
                

                List<Libros> miLista = librosDatos.list();
                librosMatris = new String[miLista.size()][librosColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    librosMatris[i][0] = miLista.get(i).getId() + "";
                    librosMatris[i][1] = miLista.get(i).getNombre() + "";
                    librosMatris[i][2] = miLista.get(i).getTipoLibro() + "";
                    librosMatris[i][3] = miLista.get(i).getOrigen() + "";
                    librosMatris[i][4] = miLista.get(i).getAutor() + "";
                    librosMatris[i][5] = miLista.get(i).getPrecio() + "";

                }
                model = new DefaultTableModel(librosMatris, librosColumns);
                librosTabla = new JTable(model);// f5 table
               

                librosSP.setViewportView(librosTabla);// f5 table

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (librosTabla.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = librosTabla.getSelectedRows();
                    ids = (String) librosTabla.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    libroTxtNombre.setText(" " + id);
                    
                    
                    // remove selected row from the model
                    model.removeRow(librosTabla.getSelectedRow());
                    try {
                        librosDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("libreta si exist e2="+e2);
                    }
                    

                   // JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });

        // CRUD Libros End

        // CRUD Cuadernos


        JPanel CuadernosPanel = new JPanel();
        CuadernosPanel.setLayout(new BoxLayout(CuadernosPanel, BoxLayout.Y_AXIS));
        JLabel cuadernosLblNombre = new JLabel("Ingrese la Marca");       
        JTextField cuadernosTxtNombre = new JTextField();

        JLabel cuadernosLblOrigen = new JLabel("Ingrese el Origen");       
        JTextField cuadernosTxtOrigen = new JTextField();

        JLabel cuadernosLblCalidad = new JLabel("Ingrese la tipo");       
        JTextField cuadernosTxtCalidad = new JTextField();

        JLabel cuadernosLblPrecio = new JLabel("Ingrese el Precio");       
        JTextField cuadernosTxtPrecio = new JTextField();
        
        JButton cuadernosBtnAdd = new JButton("Add");        
        JButton button2;  
        
         
       
        button2 = new JButton("Remove");
                
        cuadernosSP.setViewportView(cuadernosTabla);
        CuadernosPanel.add(cuadernosLblNombre);
        CuadernosPanel.add(cuadernosTxtNombre);

        CuadernosPanel.add(cuadernosLblOrigen);
        CuadernosPanel.add(cuadernosTxtOrigen);

        CuadernosPanel.add(cuadernosLblCalidad);
        CuadernosPanel.add(cuadernosTxtCalidad);

        CuadernosPanel.add(cuadernosLblPrecio);
        CuadernosPanel.add(cuadernosTxtPrecio);

        CuadernosPanel.add(cuadernosBtnAdd);
        CuadernosPanel.add(button2);
        CuadernosPanel.add(cuadernosSP);
        

        cuadernosBtnAdd.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                cuadernosId++;
                Cuadernos d = new Cuadernos();
                d.setId(cuadernosId);
                d.setNombre(cuadernosTxtNombre.getText());
                d.setOrigen(cuadernosTxtOrigen.getText());
                d.setCalidad(cuadernosTxtCalidad.getText());
                d.setPrecio(cuadernosTxtPrecio.getText());
                cuadernosDatos.create(d);
                

                List<Cuadernos> miLista = cuadernosDatos.list();
                cuadernosMatris = new String[miLista.size()][cuadernosColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    cuadernosMatris[i][0] = miLista.get(i).getId() + "";
                    cuadernosMatris[i][1] = miLista.get(i).getNombre() + "";
                    cuadernosMatris[i][2] = miLista.get(i).getOrigen() + "";
                    cuadernosMatris[i][3] = miLista.get(i).getCalidad() + "";
                    cuadernosMatris[i][4] = miLista.get(i).getPrecio() + "";

                }
                model2 = new DefaultTableModel(cuadernosMatris, cuadernosColumns);
                cuadernosTabla = new JTable(model2);// f5 table
               

                cuadernosSP.setViewportView(cuadernosTabla);// f5 table

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (cuadernosTabla.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = cuadernosTabla.getSelectedRows();
                    ids = (String) cuadernosTabla.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    cuadernosTxtNombre.setText(" " + id);
                    
                    
                    // remove selected row from the model
                    model2.removeRow(cuadernosTabla.getSelectedRow());
                    try {
                        cuadernosDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("cuadernos si exist e2="+e2);
                    }
                    

                   // JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });


        // CRUD Cuadernos End

        // Actions del JFrame
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println(" Libreria");
                JOptionPane.showMessageDialog(null, LibrosPanel, "Libreria", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Sistema de libreria simple guarda los datos sin base de datos");
                JOptionPane.showMessageDialog(null, CuadernosPanel, "Libreria", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        // Actions del JFrame End

        m1.add(m11);
        m1.add(m12);
        m1.add(m19);

        // Creando el panel en la parte inferior y agregando componentes
        JPanel footPanel = new JPanel();
        JLabel footLblCopy = new JLabel("Proyecto");
        footPanel.add(footLblCopy);

        // Agregar componentes al marco.
        add(BorderLayout.NORTH, mb);
        add(BorderLayout.SOUTH, footPanel);

    }

    public static void main(String args[]) {
        // Creando el Marco
        MainClass ex = new MainClass();
        ex.setVisible(true);

    //herencia
    Triangulo t1=new Triangulo("Estilo 1",4.0,4.0);
        Triangulo t2=new Triangulo("Estilo 2",8.0,12.0);
        System.out.println("Información para T1: ");
        t1.mostrarEstilo();
        t1.mostrarDimension();
        System.out.println("Su área es: "+t1.area());
        System.out.println();
        System.out.println("Información para T2: ");
        t2.mostrarEstilo();
        t2.mostrarDimension();
        System.out.println("Su área es: "+t2.area());

    }

}