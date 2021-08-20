package view;

import controller.ControladorRequerimientosReto4;

import model.vo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    // Mitigar errores de instancias serializable
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Imaster Java Reto 5");
        lbltitulo.setBounds(28, 6, 61, 16);
        contentPane.add(lbltitulo);

        // Dimensiona el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        // Proporciona una vista desplazable de un componente en una ventana grafica
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Consulta 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta1();
            }
        });
        btnConsuta1.setBounds(20, 537, 133, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Consulta 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta2();
            }
        });
        btnConsuta2.setBounds(157, 537, 133, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Consulta 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               consulta3();
            }
        });
        btnConsuta3.setBounds(294, 537, 133, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void consulta1(){
        try{
            ArrayList<Consulta1VO_19> lista = controlador.realizarConsulta1();
            String salida = " \t\t Proyecto de Construccion \n\nID Proyecto\tFecha_Inicio\tConstructora\t\tSerial\n\n";
            
            for (Consulta1VO_19 item : lista) {
                salida += item.getId_proyecto();
                salida += "\t";
                salida += item.getFecha_inicio();
                salida += "\t";
                salida += item.getConstructora();
                salida += "\t";
                salida += item.getSerial();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void consulta2(){
        try{
            ArrayList<Consulta2VO_19> lista = controlador.realizarConsulta2();
            String salida = " Id Proyecto y Area Maxima  \n\nID Proyecto\tArea Maxima\n\n";
            
            for (Consulta2VO_19 item : lista) {
                salida += item.getId_proyecto();
                salida += "\t";
                salida += item.getArea_max();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void consulta3(){
        try{
            ArrayList<Consulta3VO_19> lista = controlador.realizarConsulta3();
            String salida = " Id Proyecto y Lider pertenecientes a Bancolombia  \n\nID Proyecto\tNombre Apellido\n\n";
            
            for (Consulta3VO_19 item : lista) {
                salida += item.getId_proyecto();
                salida += "\t";
                salida += item.getNombreApellido();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

   
}

