UPDATE CONSUMER_ITEMS\nSET NEW_ITEM_CODE = 'your_string' || ITEM.UPC_CODE\nFROM ITEM\nWHERE CONSUMER_ITEMS.ITEM_CODE = ITEM.ITEM_CODE\nAND CONSUMER_ITEMS.ITEM_CODE IN ('item_code1', 'item_code2', 'item_code3');