str1 = "AAAA BBBB CCCC DDDD"\ntemp_placeholder = "__TEMP__"\n\nstr1 = str1.gsub("AAAA", temp_placeholder)\nstr1 = str1.gsub("CCCC", "AAAA")\nstr1 = str1.gsub(temp_placeholder, "CCCC")\n\nputs str1 # Outputs: "CCCC BBBB AAAA DDDD"