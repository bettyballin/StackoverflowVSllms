ALTER TABLE locations ADD COLUMN pt POINT;\nUPDATE locations SET pt = POINT(lng, lat);\nCREATE SPATIAL INDEX idx_locations_pt ON locations (pt);