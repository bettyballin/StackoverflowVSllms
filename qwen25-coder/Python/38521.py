import pandas as pd\n\n# Create sample DataFrames\ndf1 = pd.DataFrame({'A': ['A0', 'A1'], 'B': ['B0', 'B1']})\ndf2 = pd.DataFrame({'A': ['A2', 'A3'], 'C': ['C2', 'C3']})\n\n# SQL-like merge operation\nresult = pd.merge(df1, df2, on='A')\nprint(result)