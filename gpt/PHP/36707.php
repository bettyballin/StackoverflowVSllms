$latin1_data = "Some data in ISO-8859-1";\n    $latin5_data = iconv('ISO-8859-1', 'ISO-8859-9', $latin1_data);