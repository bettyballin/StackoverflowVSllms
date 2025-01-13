SELECT id, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) \n* cos( radians( lng ) - radians(-122) ) + sin( radians(37) ) * sin(radians(lat)) ) ) AS distance \nFROM markers \nHAVING distance < 25 \nORDER BY distance \nLIMIT 0 , 20;