SELECT t_id, height_breakdown.meters_feet\nFROM (SELECT t_id, get_distance_breakdown(h.height, h.unit_of_measure_id) AS height_breakdown\n      FROM heights h)\nWHERE 1=1;