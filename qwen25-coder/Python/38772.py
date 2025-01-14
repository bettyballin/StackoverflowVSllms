import pandas as pd\n\n# Assume df is your DataFrame from the SQL query result\ndata = ['aaa', 'bbb', 'ccc', 'ddd', 'eee', 'fff', 'ggg']\ndf = pd.DataFrame(data, columns=['col1'])\n\n# Reshape the data\nnum_columns = 3\nreshaped_df = (df.set_index(df.index // num_columns % len(df))\n               .unstack(fill_value='')\n               .sort_index(level=0, axis=1)\n               .agg(' '.join, axis=1))\n\nprint(reshaped_df.to_string(index=False))