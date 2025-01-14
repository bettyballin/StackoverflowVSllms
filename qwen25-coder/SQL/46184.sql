UPDATE Products\nSET TemplateID = (\n    SELECT T.TemplateID\n    FROM Templates AS T\n    WHERE T.TemplateName = Products.TemplateName\n)\nWHERE EXISTS (\n    SELECT 1\n    FROM Templates AS T\n    WHERE T.TemplateName = Products.TemplateName\n);