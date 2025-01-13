ifstream openInputFile( const char *cFileName ) {\n    ifstream inFile; \n    inFile.open( cFileName, ios::in );\n    return inFile;\n}\n\nbool checkName( const char *cFileName ) {\n    ifstream inFile = openInputFile( cFileName );\n\n    if ( inFile.good() ) {\n        return true;\n    } else {\n        cout << '"' << cFileName << '"' << ": File does not exist! " << endl;\n        return false;\n    }         \n}