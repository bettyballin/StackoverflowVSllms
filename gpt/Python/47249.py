import pandas as pd\n\n# Create some sample data\ndata1 = {'id': [1, 2, 3], 'value': ['A', 'B', 'C']}\ndata2 = {'id': [1, 2, 4], 'description': ['Desc1', 'Desc2', 'Desc4']}\n\n# Convert dictionaries to DataFrames\ndf1 = pd.DataFrame(data1)\ndf2 = pd.DataFrame(data2)\n\n# Perform a SQL-like join operation\nresult = pd.merge(df1, df2, on='id', how='inner')\nprint(result)