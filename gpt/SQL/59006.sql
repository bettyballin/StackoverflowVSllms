SELECT *\nFROM xml\nWHERE ExtractValue(data, '//your_xpath_expression') = 'desired_value';