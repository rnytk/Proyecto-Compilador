/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 *
 * @author walte
 */
public class Token {

    private String _token;
    private String _lexema;
    private int _linea;
    private int _columna;

    public String getLexema() {
        return this._lexema;
    }

    public String getToken() {
        return this._token;
    }

    Token(String lexema, String token,int linea,int columna) {
        this._lexema = lexema;
        this._token = token;
        this._linea = linea;
        this._columna = columna;
    }
    

    @Override
    public String toString() {
        return "Lexema: " + this._lexema + " Token: " + this._token + " Linea: "+ this._linea;
    }

    /**
     * @return the _linea
     */
    public int getLinea() {
        return _linea;
    }

    /**
     * @param _linea the _linea to set
     */
    public void setLinea(int _linea) {
        this._linea = _linea;
    }

    /**
     * @return the _columna
     */
    public int getColumna() {
        return _columna;
    }

    /**
     * @param _columna the _columna to set
     */
    public void setColumna(int _columna) {
        this._columna = _columna;
    }
    
}
