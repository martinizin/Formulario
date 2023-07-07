import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class FormularioGUI extends JFrame {
    private JTextField nombre;
    private JTextField cedula;
    private JTextField edad;

    public FormularioGUI() {
        setTitle("Formulario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nombreLabel = new JLabel("Nombre:");
        nombre = new JTextField(20);
        add(nombreLabel);
        add(nombre);
        JLabel cedulaLabel = new JLabel("Cédula:");
        cedula = new JTextField(20);
        add(cedulaLabel);
        add(cedula);
        JLabel edadLabel = new JLabel("Edad:");
        edad = new JTextField(20);
        add(edadLabel);
        add(edad);
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }

        });
        add(guardarButton);


        pack();
        setLocationRelativeTo(null);
    }
    private void guardarDatos() {
    String nombre = this.nombre.getText();
    String cedula = this.cedula.getText();
    int edad = Integer.parseInt(this.edad.getText());
        // Guardar datos en el archivo
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("formulario.txt"));
            salida.writeObject(nombre);
            salida.writeObject(cedula);
            salida.writeObject(edad);
            salida.close();
            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
        }
}
}



