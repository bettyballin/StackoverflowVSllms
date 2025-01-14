import pandas as pd\n\n# Load data\ndata = pd.read_csv('path_to_your_shapefile.csv')\n\n# Replace empty strings with a default value\ndata.fillna({'st_fips': 0, 'sfips': 0, 'county_fip': 0, 'cfips': 0, 'pl_fips': 0, 'id': 0, 'elevation': 0, 'population': 0}, inplace=True)\n\n# Convert columns to appropriate types\ndata['st_fips'] = data['st_fips'].astype(int)\ndata['sfips'] = data['sfips'].astype(int)\ndata['county_fip'] = data['county_fip'].astype(int)\ndata['cfips'] = data['cfips'].astype(int)\ndata['pl_fips'] = data['pl_fips'].astype(int)\ndata['id'] = data['id'].astype(int)\ndata['elevation'] = data['elevation'].astype(int)\ndata['population'] = data['population'].astype(int)\n\n# Save cleaned data\ndata.to_csv('cleaned_data.csv', index=False)