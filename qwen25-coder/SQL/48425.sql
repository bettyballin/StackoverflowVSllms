SELECT *\nFROM xml\nWHERE ExtractValue(data, '/root/item[1]') = 'value1';