CREATE TRIGGER convert_to_uppercase\nBEFORE INSERT OR UPDATE ON your_table\nFOR EACH ROW\nEXECUTE FUNCTION upper_case_column();\n\n-- Define the function that modifies the column\nCREATE OR REPLACE FUNCTION upper_case_column()\nRETURNS TRIGGER AS $$\nBEGIN\n  NEW.col = UPPER(NEW.col);\n  RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;