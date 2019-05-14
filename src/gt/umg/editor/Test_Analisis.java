/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.editor;

/**
 *
 * @author sckull
 */

public class Test_Analisis {

    public static void main(String[] args) {

        Lexer lexer = new Lexer("/home/sckull/U/Compiladores I/Proyecto_Compilador/Proyecto-Compilador/src/ArchivosPrueba/AnalisisLexicoPrueba.txt");

        System.out.println("Analisis Lexico");
        System.out.println("-----------------");
        
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s :  %s \n",lexer.lexemaActual() , lexer.tokenActual());
            lexer.seguir();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Hecho.");
        } else {
            System.out.println(lexer.errorMsg());
        }
    }
}
