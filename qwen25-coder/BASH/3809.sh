#!/bin/bash\n\n# Read input file terms.txt and generate SQL for table creation\ntable_name="keyterms_frq"\nfilename_field="filename VARCHAR(20),\n"\n\n# Start the SQL statement\necho "CREATE TABLE $table_name (" > create_table.sql\n\n# Add filename as first field\necho -e "$filename_field" >> create_table.sql\n\n# Read each line from terms.txt and generate SQL field definitions\nwhile IFS= read -r term; do\n    echo -n "\t`$term` VARCHAR(5)," >> create_table.sql\ndone < terms.txt\n\n# Remove the last comma, add closing parenthesis and semicolon\nsed -i '${s/,$/);/}' create_table.sql\n\necho "SQL statement written to create_table.sql"