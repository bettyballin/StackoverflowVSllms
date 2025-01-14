-- Query to get person details and contact details in desired XML format\nSELECT \n    (SELECT name AS 'Name',\n            age AS 'Age',\n            (SELECT Contact_Type AS 'ContactType',\n                    Contact_Value AS 'ContactValue'\n             FROM Person_Contact_Details\n             WHERE id = 12\n             FOR XML PATH('ContactDetail'), TYPE\n            ) AS 'ContactDetails'\n     FROM Person_Details\n     WHERE id = 12\n     FOR XML PATH('PersonDetails'), ROOT('Root')\n    ) AS XmlResult