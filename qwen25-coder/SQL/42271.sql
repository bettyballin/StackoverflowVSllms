START TRANSACTION;\n\n-- Lock and select up to 100 URLs for processing\nSELECT url \nFROM urls \nWHERE task_assigned IS NULL \nORDER BY id \nLIMIT 100 \nFOR UPDATE;\n\n-- Update the selected rows to mark them as being processed\nUPDATE urls \nSET task_assigned = NOW() \nWHERE task_assigned IS NULL \nORDER BY id \nLIMIT 100;\n\nCOMMIT;