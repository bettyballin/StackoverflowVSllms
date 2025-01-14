import pandas as pd\n\n# Assuming you have your database connection set up as 'conn'\nquery = """\nSELECT * FROM your_table_name;\n"""\ndf = pd.read_sql(query, conn)\n\ndef analyze_row(row):\n    abs_values = row[1:].abs()\n    max_abs_val_index = abs_values.idxmax()\n    sign = '>' if row[max_abs_val_index] > 0 else '<' if row[max_abs_val_index] < 0 else '='\n    \n    feature = max_abs_val_index.replace('_', ' ')\n    return f"{row['word']}: {'probably not' if sign == '<' else ''} {feature};"\n\ndf['analysis'] = df.apply(analyze_row, axis=1)\nprint(df['analysis'])