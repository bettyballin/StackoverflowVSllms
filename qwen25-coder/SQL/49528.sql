CREATE TRIGGER first_trigger\nBEFORE INSERT ON your_table\nFOR EACH ROW EXECUTE PROCEDURE your_procedure_1();\n\nCREATE TRIGGER second_trigger\nAFTER INSERT ON your_table\nFOR EACH ROW EXECUTE PROCEDURE your_procedure_2();