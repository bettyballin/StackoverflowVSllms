for(i = 0; i < n; i++)\n{\n    char* b = malloc(10 * sizeof(char));  // assuming i won't be more than 9 digits\n    if (b != NULL)  // check if the allocation was successful\n    {\n        sprintf(b, "%d", i);\n        // don't forget to free the memory when you're done with it\n        free(b);\n    }\n}