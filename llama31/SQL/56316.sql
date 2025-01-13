-- First, add a new column at the desired position (in this case, after the 36th column)\nALTER TABLE person ADD COLUMN new_dob DATE;\n\n-- Then, update the new column with the values from the old column\nUPDATE person SET new_dob = dob;\n\n-- Finally, drop the old column and rename the new column to the original name\nALTER TABLE person DROP COLUMN dob;\nALTER TABLE person RENAME COLUMN new_dob TO dob;