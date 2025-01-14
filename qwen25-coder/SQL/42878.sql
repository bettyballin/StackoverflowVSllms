SELECT homes.home_id, \n    address, \n    city, \n    state, \n    zip, \n    price, \n    photo_id, \n    photo_url_dir\nFROM homes\nLEFT OUTER JOIN home_photos ON homes.home_id = home_photos.home_id\n    AND homes.primary_photo_group_id = home_photos.home_photo_group_id\n    AND home_photos.home_photo_type_id = 2\nWHERE homes.display_status = true\nAND homes.price BETWEEN 500000 AND 1000000;