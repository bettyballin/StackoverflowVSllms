SELECT \n    (\n        SELECT \n            Name AS 'name',\n            NULL AS 'description', -- Placeholder for structure\n            NULL AS 'description'  -- Another placeholder for structure\n        FOR XML PATH('person'), TYPE\n    ).query('\n        <person>\n            <name>{data(/person/name)}</name>\n            <description xsi:type="me:age">{sql:variable("@Age")}</description>\n            <description xsi:type="me:height">{sql:variable("@Height")}</description>\n        </person>\n    ') AS XMLResult\nFROM \n    (SELECT Name, Age, Height FROM Person) AS p;