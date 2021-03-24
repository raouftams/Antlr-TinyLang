grammar TinyLang;
@header {
    package antlr;
    }

/*Grammar rules */

programme: 'compil' NOM_PROG '(' ')' '{' declarations 'Start' instructions '}' EOF ;

declarations: declaration declarations| declaration |;

declaration: type identifiants ';';

type: 'intCompil'| 'floatCompil'| 'stringCompil';

identifiants: IDENTIFIANT ',' identifiants | IDENTIFIANT ;

instructions: instruction instructions| instruction;

instruction: affectation| expression| condition| boucle| scan| print;

affectation: IDENTIFIANT AFFECTATION expression ';';
// ANTLR résout les ambiguïtés et donne la priorité au premiéres alternatives utilisées
// dans ce cas "!=" > "==" > "<" > ... > "/".
expression: expression '!=' expression
            | expression '==' expression
            | expression '<' expression
            | expression '>' expression
            | expression '-' expression
            | expression '+' expression
            | expression '*' expression
            | expression '/' expression
            | IDENTIFIANT| CNST| INT| FLOAT| STRING;

condition: 'IF''(' expression ')''then''{'instructions'}' optelse;
optelse: 'else''{' instructions '}'| ;

boucle: 'do' '{' instructions '}' 'while' '(' expression ')';

scan: 'scanCompil''('identifiants')'';';

print: 'printCompil''('print_val')'';';
print_val: STRING | identifiants;


/* TOKENS */
SINGLE_LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
MULTIPLE_LINE_COMMENT: '/*' (MULTIPLE_LINE_COMMENT|.)*? '*/' -> channel(HIDDEN);
NOM_PROG: [A-Z]([_]?[a-z A-Z])*;
IDENTIFIANT:[a-zA-Z][a-zA-Z0-9]*;
AFFECTATION: '=';
CNST: ([1-9][0-9]*|'0');
INT: [+]?([1-9][0-9]*|'0');
FLOAT: '0'|[+]?[1-9][0-9]*('.'[0-9]*) ;
STRING: '"' .*? '"';
WHITESPACE: [ \n\t\r] -> skip;