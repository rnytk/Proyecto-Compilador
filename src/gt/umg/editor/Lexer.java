/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.editor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author sckull
 */

public class Lexer {
    private StringBuilder input = new StringBuilder();
    private Token token;
    private String lexema;
    private boolean exausthed = false;
    private String errorMsg = "";
    private Set<Character> blankChars = new HashSet<Character>();

    public Lexer(String direccionArchivo) {
        try (Stream<String> st = Files.lines(Paths.get(direccionArchivo))) {
            st.forEach(input::append);
        } catch (IOException ex) {
            exausthed = true;
            errorMsg = "Could not read file: " + direccionArchivo;
            return;
        }

        blankChars.add('\r');
        blankChars.add('\n');
        blankChars.add((char) 8);
        blankChars.add((char) 9);
        blankChars.add((char) 11);
        blankChars.add((char) 12);
        blankChars.add((char) 32);

        seguir();
    }

    public void seguir() {
        if (exausthed) {
            return;
        }

        if (input.length() == 0) {
            exausthed = true;
            return;
        }

        ignorarEspaciosBlancos();

        if (encSiguienteToken()) {
            return;
        }

        exausthed = true;

        if (input.length() > 0) {
            errorMsg = "Unexpected symbol: '" + input.charAt(0) + "'";
        }
    }

    private void ignorarEspaciosBlancos() {
        int charsToDelete = 0;

        while (blankChars.contains(input.charAt(charsToDelete))) {
            charsToDelete++;
        }

        if (charsToDelete > 0) {
            input.delete(0, charsToDelete);
        }
    }

    private boolean encSiguienteToken() {
        for (Token t : Token.values()) {
            int end = t.endOfMatch(input.toString());

            if (end != -1) {
                token = t;
                lexema = input.substring(0, end);
                input.delete(0, end);
                return true;
            }
        }

        return false;
    }

    public Token tokenActual() {
        return token;
    }

    public String lexemaActual() {
        return lexema;
    }

    public boolean isSuccessful() {
        return errorMsg.isEmpty();
    }

    public String errorMsg() {
        return errorMsg;
    }

    public boolean isExausthed() {
        return exausthed;
    }
}