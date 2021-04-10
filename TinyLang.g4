grammar TinyLang;
@header {
    package antlr;
    }

/*Grammar rules */

programme: 'compil' NOM_PROG '(' ')' '{' declarations 'start' instructions '}' EOF ;

declarations: declaration declarations| declaration |;

declaration: type identifiants ';';

type: 'intCompil'| 'floatCompil'| 'stringCompil';

identifiants: IDENTIFIANT ',' identifiants | IDENTIFIANT ;

instructions: instruction instructions| instruction;

instruction: affectation| expressionArithmetique| condition| boucle| scan| print;

affectation: IDENTIFIANT AFFECTATION expressionArithmetique ';';
// ANTLR résout les ambiguïtés et donne la priorité au premiéres alternatives utilisées
// dans ce cas "!=" > "==" > "<" > ... > "/".
expressionArithmetique:  lp expressionArithmetique rp
            | expressionArithmetique opt expressionArithmetique
            | IDENTIFIANT| CNST| INT| FLOAT;

// Les opérateurs arithmétiques
opt: '/' | '*' | '+' | '-';
//les parenthéses
lp: '(';
rp: ')';
expressionLogique: expressionArithmetique opl expressionArithmetique;

// Les opérateurs logiques
opl: '!=' | '==' | '<' | '>';

condition: 'if''(' expressionLogique ')''then''{'instructions'}' optelse;
optelse: 'else''{' instructions '}'| ;

boucle: 'do' '{' instructions '}' 'while' '(' expressionLogique ')';

scan: 'scanCompil''('identifiants')'';';

print: 'printCompil''('print_val')'';';
print_val: STRING | identifiants;


/* TOKENS */
SINGLE_LINE_COMMENT: '//' ~[\r\n]* -> skip;
MULTIPLE_LINE_COMMENT: '/*' (MULTIPLE_LINE_COMMENT|.)*? '*/' -> skip;
NOM_PROG: [A-Z]([_]?[a-z A-Z])*;
IDENTIFIANT:[a-zA-Z][a-zA-Z0-9]*;
AFFECTATION: '=';
CNST: ([1-9][0-9]*|'0');
INT: [+]?([1-9][0-9]*|'0');
FLOAT: '0'|[+]?[1-9][0-9]*('.'[0-9]*) ;
STRING: '"' .*? '"';
WHITESPACE: [ \n\t\r] -> skip;