/* Sección de declaraciones de JFlex */
package lexico;
%%
%public
%unicode
%line
%column
%full
%class Lexer

%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 
 public boolean existenTokens(){
 return this._existenTokens;
 }
 
%}
 
 /* Al utilizar esta instrucción, se le indica a JFlex que devuelva objetos del tipo Token */
%type Token
 
%init{
 /* Código que se ejecutará en el constructor de la clase */
%init}
 
%eof{
 
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 
%eof}
 
/* Inicio de Expresiones regulares */
 
 Digito = [0-9]
 Numero = {Digito} {Digito}*
 Letra = [A-Za-z]
 Reservado = {Letra} {Letra}*
 SimboloAritmetico = "*"|"+"|"-"|"/"|"="
 SimboloAgrupacion = "("|")"|"{"|"}"|"["|"]"
 SimboloComparacion = "<"|">"
 EspacioBlanco	= {SaltoDeLinea} | [ \t\f]


/*COMENTARIOS IGNORADOS*/
SaltoDeLinea = \n|\r|\r\n
InputCharacter = [^\r\n]
EndOfLineComment = "//" {InputCharacter}* {SaltoDeLinea}?
DocumentationComment = "/**" {CommentContent} "*"+ "/" 
CommentContent	= ( [^*] | \*+ [^/*] )*
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
Commentario = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
 
 

 
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 



/* Inicia sección de reglas. Cada regla está formada por una {expresión} espacio {código}*/
 

/*PALABRAS RESERVADAS*/
<YYINITIAL> "const"      {
this._existenTokens = true;
return new Token(yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
}
<YYINITIAL> "function"      {
this._existenTokens = true;
return new Token(yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
}
<YYINITIAL> "let"      {
this._existenTokens = true;
return new Token(yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
} 
<YYINITIAL> "var"      {
this._existenTokens = true;
return new Token(yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
}
<YYINITIAL> "return"      {
this._existenTokens = true;
return new Token(yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
}       

 
<YYINITIAL> {Numero}      { 
this._existenTokens = true;
return new Token(yytext(),"NUMERO",yyline,yycolumn);
}

{Commentario}                   { /* ignore */ }

<YYINITIAL> {Reservado} {
 this._existenTokens = true;
 return new Token(yytext(), "IDENTIFICADOR",yyline,yycolumn);
}
 
<YYINITIAL> {SimboloAritmetico} {
 this._existenTokens = true;
 return new Token(yytext(), "SIMBOLO_ARITMETICO",yyline,yycolumn);
}

<YYINITIAL> {SimboloAgrupacion} {
 this._existenTokens = true;
 return new Token(yytext(), "SIMBOLO_AGRUPACION",yyline,yycolumn);
}

<YYINITIAL> {SimboloComparacion} {
 this._existenTokens = true;
 return new Token(yytext(), "SIMBOLO_COMPARACION",yyline,yycolumn);
}
 
<YYINITIAL> {EspacioBlanco} {/* ignore */}




[^]                       { throw new Error("Caracter Ilegal <"+ yytext()+ ">"); }
