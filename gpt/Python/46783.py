import dask.dataframe as dd\n\n   df = dd.read_csv('large_file.csv')\n   print(df.head())