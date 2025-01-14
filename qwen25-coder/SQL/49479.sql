SELECT zip, COUNT(DISTINCT address_id) AS LOCATIONS\nFROM records \nINNER JOIN addresses a USING(address_id) \nINNER JOIN zip_coords z1 ON records.zip = z1.zip\nWHERE EXISTS (\n    SELECT 1 \n    FROM zip_coords z2,\n    LATERAL (SELECT distance(z1.latitude, z1.longitude, z2.latitude, z2.longitude) AS d FROM dual)\n    WHERE z2.zip IN (\n        SELECT zip FROM available_zips\n    )\n    AND d <= 50\n)\nGROUP BY ZIP;