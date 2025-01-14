%{
#include <stdio.h>
%}

%option noyywrap

%{
void process_comment(const char *comment);
%}

%x COMMENT

%%

"/*"            { BEGIN(COMMENT); }
<COMMENT>"*/"   { BEGIN(INITIAL); }
<COMMENT>[^*]+  { process_comment(yytext); }
<COMMENT>"*"[^/] { process_comment(yytext); }

%%

void process_comment(const char *comment) {
    // Process or print the comment block
    printf("Comment block: %s
", comment);
}

int main() {
    yylex();
    return 0;
}