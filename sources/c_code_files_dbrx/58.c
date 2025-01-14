#include <stdio.h>

// Define the state enum
enum { NONE = 0, IN_COMMENT };

// Define the functions
void start_comment()       { printf("START COMMENT\n"); }
void end_comment()         { printf("END COMMENT\n"); }
void inside_comment()      { printf("INSIDE COMMENT -> ignoring\n"); }

// Define the Flex scanner
#include <FlexLexer.h>

int main(int argc, char **argv) {
    // Create a new Flex scanner
    yyFlexLexer* lexer = new yyFlexLexer();

    // Set the input to the standard input
    lexer->yyin = stdin;

    // Run the scanner
    lexer->yylex();

    // Delete the scanner
    delete lexer;

    return 0;
}

// Define the Flex rules
void* yyFlexLexer::yyalloc(size_t size) { return malloc(size); }
void yyFlexLexer::yyfree(void* ptr) { free(ptr); }

%%

"/*"                   { start_comment();     BEGIN(IN_COMMENT); }
<IN_COMMENT>"*/"       { end_comment();       BEGIN(NONE);      }
<IN_COMMENT>"/"        { inside_comment();    /* Ignore inner comment */ }

%%