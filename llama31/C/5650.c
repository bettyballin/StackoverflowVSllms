if (strncmp("min_start", sqlite3_column_name(stmt,i), strlen("min_start")) == 0)\n{\n    // ...\n}\nif (strncmp("max_end", sqlite3_column_name(stmt,i), strlen("max_end")) == 0)\n{\n    // ...\n}