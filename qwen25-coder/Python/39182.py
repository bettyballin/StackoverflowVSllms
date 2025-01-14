from sqlalchemy import create_engine, text\nimport pandas as pd\n\ndef get_table_data(connection_string, table_name, primary_key):\n    engine = create_engine(connection_string)\n    with engine.connect() as connection:\n        # SQL query to fetch data using the provided primary key for sorting and comparison\n        query = f"SELECT * FROM {table_name} ORDER BY {primary_key};"\n        df = pd.read_sql_query(text(query), connection)\n    return df\n\ndef compare_tables(df1, df2):\n    # Identify common columns only\n    common_columns = df1.columns.intersection(df2.columns)\n    df1_common = df1[common_columns].sort_index(axis=1)\n    df2_common = df2[common_columns].sort_index(axis=1)\n\n    # Find rows that are only in either table and value differences\n    diff = df1_common.compare(df2_common, result_names=("df1", "df2"))\n    \n    # Rows only in each dataframe\n    only_in_df1 = df1_common.loc[~df1_common.index.intersection(df2_common.index)]\n    only_in_df2 = df2_common.loc[~df2_common.index.intersection(df1_common.index)]\n\n    return diff, only_in_df1, only_in_df2\n\n# Example usage\nconnection_string_1 = "your_oracle_connection_string_here"\nconnection_string_2 = "your_db2_connection_string_here"\ntable_name_1 = "your_table_name_1"\ntable_name_2 = "your_table_name_2"\nprimary_key = "your_primary_key_column"\n\ndf1 = get_table_data(connection_string_1, table_name_1, primary_key)\ndf2 = get_table_data(connection_string_2, table_name_2, primary_key)\n\ndiff, only_in_df1, only_in_df2 = compare_tables(df1, df2)\n\n# Output results to CSV or report\nwith open('table_comparison_report.csv', 'w') as f:\n    f.write("Differences:\n")\n    diff.to_csv(f)\n    f.write("\nOnly in first table:\n")\n    only_in_df1.to_csv(f)\n    f.write("\nOnly in second table:\n")\n    only_in_df2.to_csv(f)