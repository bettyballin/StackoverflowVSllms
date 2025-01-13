#define PRINT(DATA,N) for(int i=0; i<N; i++) { cout << (i>0?", ":"") << DATA[i]; } cout << endl;\n\nint\nmain()  \n{\n    // Creating and Sorting a stack-based array.\n  int d [10] = { 1, 4, 0, 2, 8, 6, 3, 5, 9, 7 };\n  PRINT(d,10);\n  sort( d, d+10 );\n  PRINT(d,10);\n\n  cout << endl;\n\n    // Creating a vector.\n  int eData [10] = { 1, 4, 0, 2, 8, 6, 3, 5, 9, 7 };\n  vector<int> e;\n  for(int i=0; i<10; i++ )\n    e.push_back( eData[i] );\n\n    // Sorting a vector.\n  PRINT(e,10);\n  sort(e.begin(), e.end());\n  PRINT(e,10);\n}