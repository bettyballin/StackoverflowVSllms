%{\n/* C code and definitions */\n%}\n/*\n    Define your start conditions here if needed\n*/\n%%\n\n"<"          ECHO; /* This could be any text outside the comment blocks */\n">"          ECHO;\n\n"\/\*"       BEGIN(COMMENT); /* Start of a comment block */\n\n<COMMENT>\".*\"  {ECHO;}   /* Match any line starting with * (optional) inside comment*/\n\n<COMMENT>"\*\/"    {BEGIN(INITIAL);}   /* End of a comment block */\n\n.|\n         ECHO; /* This will echo everything else as is, including newlines outside comments*/\n%%\n\nint yywrap() {\n    return 1;\n}\n\n/* Main function where Flex starts processing */\nint main(int argc, char** argv) {\n    yyparse();\n    return 0;\n}