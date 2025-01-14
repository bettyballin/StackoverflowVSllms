import pandas as pd\nfrom sqlalchemy import create_engine\n\n# Load CSV file into DataFrame\ndf = pd.read_csv('yourfile.csv')\n\n# Add a constant column with value 2\ndf['ID'] = 2\n\n# Create an SQLAlchemy engine (example for SQLite)\nengine = create_engine('sqlite:///yourdatabase.db')\n\n# Insert data into SQL table, replace_table if it exists or use append\ndf.to_sql('yourtable', con=engine, index=False, if_exists='replace')