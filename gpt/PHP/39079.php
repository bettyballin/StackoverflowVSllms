$string = getStringFromDatabase();\n\n// Remove non-printable characters\n$clean_string = preg_replace('/[[:^print:]]/', '', $string);\n\nprintf($clean_string);