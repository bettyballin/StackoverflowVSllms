DECLARE @result XML;\nDECLARE @input XML;\n\n-- Assuming @input is populated with your XML data\nSET @input = '<YourXMLdata></YourXMLdata>';\n\n-- Generate XML and store in variable\nSELECT @result = (\n    SELECT *\n    FROM YourTable\n    FOR XML AUTO, TYPE\n);\n\n-- Output the result if needed\nSELECT @result;