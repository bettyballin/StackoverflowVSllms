-- Update statistics\nANALYZE TABLE your_table_name;\n\n-- Create index\nCREATE INDEX idx_bit_column ON your_table_name (c);\n\n-- Analyze query plan\nEXPLAIN SELECT * FROM a_view WHERE c = 0;\nEXPLAIN SELECT * FROM a_view WHERE c = 1;