void\nCsvParser::run (void * null)\n{\n    // ...\n    Cell **new_fields = (Cell **)g_realloc(this->fields, maxOfFields * sizeof(Cell *));\n    if (new_fields == NULL) {\n        // Handle the error\n    }\n    this->fields = new_fields;\n    // ...\n}