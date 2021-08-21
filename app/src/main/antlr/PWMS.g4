grammar PWMS;
@header {
    package pers.ruikai.pwms.compiler;
}

CATEGORY: 'category';
DOT: '.';
DASH : '-';
WS : [ \u000D\t\n] -> skip ;
YEAR: [0-9][0-9][0-9][0-9];
NUM2: [0-9][0-9];
IN: 'IN';
OUT: 'OUT';
INTEGER: [0-9]+;
ID : (~ [ \n\u000D\t.0-9-])(~ [ \n\u000D\t.])*;

records: category* record*;
category: CATEGORY name code attrname* DOT;
record: date? (IN|OUT) name number unit attrvalue* (DOT note)? DOT;
name: ID;
code: INTEGER;
attrname: ID;

date: YEAR DASH NUM2 DASH NUM2;
number: INTEGER;
unit: ID;
note: ID;
attrvalue: ID | INTEGER;