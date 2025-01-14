-- Assuming you are looking for extensions on a standard table like CustTable\nSELECT \n    T1.AccountNum,\n    T2.YourCustomFieldName\nFROM \n    CustTable AS T1\nLEFT JOIN \n    CustTable_EXT AS T2  -- Replace with the actual extension table name\nON \n    T1.RecId = T2.ParentRecId;  -- Join on the ParentRecId which links to the base record