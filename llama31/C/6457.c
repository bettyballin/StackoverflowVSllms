char * get_next_id(char *last_id)\n{\n    int x, pos;\n    char *next_id = NULL;\n    char is_alnum = 1;\n\n    // if the last id is -1 (non-existant), start at the begining with 0\n    if (strlen(last_id) == 0)\n    {\n        next_id = malloc(2 * sizeof(char));\n        strcpy(next_id, "0");\n    }\n    else\n    {\n        // check the input\n        for(x = 0; last_id[x]; x++)\n        {\n            if(!isalnum(last_id[x]))\n            {\n                is_alnum = 0;\n                break;\n            }\n        }\n\n        if (is_alnum == 0)\n        {\n            return "";\n        }\n\n        // all chars to lowercase\n        for(x = 0; last_id[x]; x++)\n        {\n            last_id[x] = tolower(last_id[x]);\n        }\n\n        // loop through the id string until we find a character to increment\n        for (x = 1; x <= strlen(last_id); x++)\n        {\n            pos = strlen(last_id) - x;\n\n            if (last_id[pos] != 'z')\n            {\n                next_id = increment_id(last_id, pos);\n                break; // <- kill the for loop once we've found our char\n            }\n        }\n\n        // if every character was already at its max value (z),\n        // append another character to the string\n        if (next_id == NULL)\n        {\n            next_id = append_id(last_id);\n        }\n    }\n\n    return next_id;\n}