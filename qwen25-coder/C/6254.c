// Example DLL function in C that returns a string\n#ifdef __cplusplus\nextern "C" {\n#endif\n\nconst char* getStringFromDLL() {\n    return "Hello from DLL!";\n}\n\n#ifdef __cplusplus\n}\n#endif