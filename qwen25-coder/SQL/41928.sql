UPDATE locations\nSET location_point = POINT(lng, lat);\n\nCREATE SPATIAL INDEX idx_location_point ON locations(location_point);