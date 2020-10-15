grammar ExpressionDecode;

expr:
expression EOF #exprCalc;
expression
:
operatorToken=(MIN|MAX)'('expression','expression')' #minMaxExpr
|'(' expression ')' #parenthesesExpr
|SUBTRACT expression #minusExpr
|expression operatorToken=(MULTIPLY|DIVIDE|DIV|MOD) expression #multiplyExpr
|expression operatorToken=(ADD|SUBTRACT) expression #additiveExpr
|expression operatorToken=(EQUALS|LESS|MOR) expression #comparativeExpr
|NOT expression #notExpr
|NUMBER #boolExpr
|LINK #linkExpr ;

MIN:'min';
MAX:'max';
NUMBER:'0'..'9'+ ('.' '0'..'9'+)?;
ADD:'+';
SUBTRACT:'-';
MULTIPLY:'*';
DIVIDE:'/';
NOT:'!';
EQUALS:'=';
LESS:'<';
MOR:'>';
MOD:'mod';
DIV:'div';
LINK:WORD '1'..'9' '0'..'9'*;
WORD:CHAR+;
CHAR:'a'..'z'|'A'..'Z';
