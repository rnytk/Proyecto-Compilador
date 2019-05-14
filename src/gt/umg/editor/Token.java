/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.editor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sckull
 */

/*
* Este metodo contiene la lista de tokens de Python
*/
public enum Token {
    //TOKENS PRUEBA
    TK_RESTA ("-"), 
    TK_MAS ("\\+"), 
    TK_MULT ("\\*"), 
    TK_DIV ("/"), 
    TK_NO ("~"), 
    TK_AND_ascii  ("&"),  
    TK_OR_ascii ("\\|"),  
    TK_MENOR ("<"),
    TK_MENOR_QUE ("<="),
    TK_MAYOR (">"),
    TK_MAYOR_QUE (">="), 
    TK_IGUAL ("=="),
    TK_ASIGNACION ("="),
    TK_DELIMITADOR_APERTURA_PR ("\\("),
    TK_DELIMITADOR_CERRAR_PR ("\\)"), 
    TK_COMA (","),       
    TK_DOBLE_PUNTO (":"),
    TK_DELIMITADOR_APERTURA_BRACKET ("\\{"),
    TK_DELIMITADOR_CERRAR_BRACKET ("\\}"),
    TK_DELIMITADOR_APERTURA_LLAVE ("\\["),
    TK_DELIMITADOR_CERRAR_LLAVE ("\\]"),
    TK_DIFERENTE ("<>"),
    TK_MOD ("%"),
    
    //TOKENS: PALABRAS RESERVADAS PYTHON
    TK_AND ("and"),
    TK_DEL ("del"),
    TK_FOR ("for"),
    TK_IS ("is"),
    TK_RAISE ("raise"),
    TK_ASSERT ("assert"),
    TK_IF ("if"),
    TK_ELSE ("else"),
    TK_ELIF ("elif"),
    TK_FROM ("from"),
    TK_LAMBDA ("lambda"),
    TK_RETURN ("return"),
    TK_BREAK ("break"),
    TK_GLOBAL ("global"),
    TK_NOT ("not"),
    TK_TRY ("try"),
    TK_CLASS ("class"),
    TK_EXCEPT ("except"),
    TK_OR ("or"),
    TK_WHILE ("while"),
    TK_CONTINUE ("continue"),
    TK_EXEC ("exec"),
    TK_IMPORT ("import"),
    TK_YIELD ("yield"),
    TK_DEF ("def"),
    TK_FINALLY ("finally"),
    TK_IN ("in"),
    TK_PRINT ("print"),    
    TK_INPUT ("input"),
    TK_FILTER ("filter"),
    TK_LIST ("list"),
    TK_MAIN ("__main__"),
    TK_STR ("__str__"),
    TK_INIT ("__init__"),
    TK_SELF ("self"),
    TK_NAME ("__name__"),
    //TK_COMENTARIO ("(\\#)\\."),
    //TK_COMENTARIO_("/\\*(?:.|[\\n\\r])*?\\*/"),
    //TK_PRINT_DATO("print("),

    TK_STRING ("\"[^\"]+\""),
    TK_INTEGER ("\\d+"), 
    TK_REAL ("(\\d*)\\.\\d+"),
    TK_IDENTIFICADOR ("\\w+");

    private final Pattern patron;

    Token(String regex) {
        patron = Pattern.compile("^" + regex);
    }
    /*
    * Si coincide con el patron, regresa un entero con el tamaño del string que evaluó.
    */
    int endOfMatch(String s) {
        Matcher m = patron.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}