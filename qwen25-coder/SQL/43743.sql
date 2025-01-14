UPDATE im\nSET mf_item_number = 'NewValue' -- Replace 'NewValue' with the actual value or column reference you want to set\nFROM item_master im\nJOIN group_master gm ON im.sku = gm.sku\nJOIN Manufacturer_Master mm ON gm.ManufacturerID = mm.ManufacturerID\nWHERE im.mf_item_number LIKE 'STA%'\n  AND gm.manufacturerID = 34;