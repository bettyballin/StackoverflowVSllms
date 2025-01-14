-- Start a transaction\nBEGIN;\n\n-- Use a temporary value that does not exist in the unique_column\n-- Swap the value of the first row to a temporary value\nUPDATE my_table\nSET unique_column = 'temp_value'\nWHERE id = 1;\n\n-- Swap the value of the second row to the first row's original value\nUPDATE my_table\nSET unique_column = (SELECT unique_column FROM my_table WHERE id = 2)\nWHERE id = 1;\n\n-- Now set the second row's value to the temporary value\nUPDATE my_table\nSET unique_column = 'temp_value'\nWHERE id = 2;\n\n-- Finally, set the first row's value to the second row's original value\nUPDATE my_table\nSET unique_column = (SELECT unique_column FROM my_table WHERE id = 1)\nWHERE id = 2;\n\n-- Commit the transaction\nCOMMIT;