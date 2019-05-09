/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author walte
 */
public class Abrir {

    public void AbrirArchivo(JFileChooser abrirArchivo, JTextArea areaMostrar) {
        // TODO add your handling code here:
        areaMostrar.setText("");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos unicamente", "txt", "doc", "docx","js","html");
        abrirArchivo.setFileFilter(filter);
        int seleccion = abrirArchivo.showOpenDialog(areaMostrar);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File fichero = abrirArchivo.getSelectedFile();
                BufferedReader buffeRead = new BufferedReader(new FileReader(fichero));
                String linea = buffeRead.readLine();
                while (linea != null) {
                    areaMostrar.append(linea);
                    String retornoDeCarro = System.getProperty("line.separator");
                    areaMostrar.append(retornoDeCarro);
                    linea = buffeRead.readLine();
                }
                areaMostrar.setCaretPosition(0);
                buffeRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
