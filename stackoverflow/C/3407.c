const int MAX_SIZE = 1024;\nchar buf[MAX_SIZE];\nif (!fgets(buf, MAX_SIZE, fFile) {\n  cerr << "Read error";\n  exit(1);\n}\ndouble Value = Utvardering(buf);