SELECT *\nFROM building\nLEFT JOIN (SELECT building, etc. FROM men GROUP BY etc.) AS men_summary\n    ON building.name = men_summary.building_name\nLEFT JOIN (SELECT building, etc. FROM women GROUP BY etc.) AS women_summary\n    ON building.name = women_summary.building_name