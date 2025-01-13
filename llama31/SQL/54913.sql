-- Create a table to store locations with geocoded coordinates\nCREATE TABLE locations (\n  id SERIAL PRIMARY KEY,\n  zip_code VARCHAR(10),\n  lat DECIMAL(10, 8),\n  lon DECIMAL(11, 8),\n  geom geometry(Point, 4326)\n);\n\n-- Create a spatial index on the geom column\nCREATE INDEX locations_geom_idx ON locations USING GIST (geom);\n\n-- Insert sample data\nINSERT INTO locations (zip_code, lat, lon, geom)\nVALUES ('12345', 37.7749, -122.4194, ST_MakePoint(-122.4194, 37.7749, 4326));\n\n-- Query locations within 1 mile of a given zip code\nSELECT *\nFROM locations\nWHERE ST_DWithin(geom, ST_MakePoint(-122.4194, 37.7749, 4326), 1609.34); -- 1 mile in meters