import folium\n    from folium.plugins import HeatMap\n    import pandas as pd\n\n    # Load your data into a pandas DataFrame\n    data = pd.read_csv('your_data.csv')\n\n    # Filter data based on your criteria (e.g., quality='good')\n    filtered_data = data[data['quality'] == 'good']\n\n    # Create a base map\n    base_map = folium.Map(location=[latitude, longitude], zoom_start=10)\n\n    # Create a heatmap\n    heat_data = [[row['latitude'], row['longitude']] for index, row in filtered_data.iterrows()]\n    HeatMap(heat_data).add_to(base_map)\n\n    # Save map\n    base_map.save('heatmap.html')