FILE *file = fopen("example.txt", "r");\n   if (file == NULL) {\n       perror("Error opening file");\n       // Handle error\n   }