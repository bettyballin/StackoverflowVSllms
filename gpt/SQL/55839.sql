BEGIN TRAN A\n\nSET TRANSACTION ISOLATION LEVEL REPEATABLE READ;\n\nSELECT id\nFROM Inventory\nWITH (HOLDLOCK)\nWHERE material_id = 25 AND quantity > 10;\n\n/*\nProcess some things using the inventory record and\neventually write some updates that are dependent on the fact that\nthat specific inventory record had sufficient quantity (greater than 10).\n*/\n\nCOMMIT TRAN A