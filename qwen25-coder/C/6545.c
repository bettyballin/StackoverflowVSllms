typedef void (*FuncPtr)();\n\nconst FuncPtr functions[] = {player1Function, player2Function};\nconst char* functionNames[] = {"player1", "player2"};\nconst int numFunctions = sizeof(functions) / sizeof(FuncPtr);