DECLARE @myDoc XML = '<CustomerInfo><ID>1</ID></CustomerInfo>';\nDECLARE @newName nvarchar(50) = 'Customer';\n\nSELECT @myDoc.query('\n    element {sql:variable("@newName")} {\n        /CustomerInfo/* \n    }\n');