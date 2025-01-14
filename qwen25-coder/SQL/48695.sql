SELECT \n    pl.id AS product_line_id,\n    pl.name AS product_line_name,\n    pl.description AS description,\n    i.imageFileLocation AS thumbnail_image_location\nFROM \n    ProductLines pl\nLEFT JOIN (\n    SELECT \n        specificProductID, \n        MIN(imageID) as imageID  -- Assuming image ID order can determine "first" or "thumbnail"\n    FROM \n        ProductImageLinks\n    GROUP BY \n        specificProductID\n) pil ON pl.id = sp.productLineID\nJOIN SpecificProducts sp ON pl.id = sp.productLineID\nLEFT JOIN Images i ON pil.imageID = i.id;