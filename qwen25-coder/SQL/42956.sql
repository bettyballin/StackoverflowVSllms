-- Sample XML structure before modification\nDECLARE @ExistingXML xml\nSET @ExistingXML = N'<Log>\n    <Step>Initial Step</Step>\n    <Step>Second Step</Step>\n  </Log>';\n\n-- New XML data to be merged\nDECLARE @NewXML xml\nSET @NewXML = N'<ProcessingInfo>Date=2023-11-05, Status=Completed</ProcessingInfo>';\n\n-- Insert or update the row in the table with the existing XML\nMERGE INTO MyTable AS target\nUSING (SELECT @ExistingXML AS XmlData) AS source(XmlData)\nON 1 = 1 -- Assuming you're updating a specific row, modify this condition as needed\nWHEN MATCHED THEN\n    UPDATE SET \n        target.XmlData.modify('insert sql:variable("@NewXML") into (/Log)[1]')\n\n-- If the row is not found and you want to insert\nWHEN NOT MATCHED THEN\n    INSERT (XmlData)\n    VALUES (@ExistingXML);