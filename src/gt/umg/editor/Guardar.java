/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author walte
 */
public class Guardar {

    private PrintWriter writer = null;
    private int seleccion;

    public void GuardarInformacion(JFileChooser archivoGuardar, JTextArea areaTexto) {
        seleccion = archivoGuardar.showSaveDialog(areaTexto);
        if (seleccion == 0) {
            try {
                File fichero = archivoGuardar.getSelectedFile();
                writer = new PrintWriter(fichero);
                writer.print(areaTexto.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                writer.close();
            }
        }
    }
}
