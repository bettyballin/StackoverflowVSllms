SELECT [columns],\n       3963.191 * ACOS(\n           (SIN(PI() * [latitude] / 180) * SIN(PI() * [column].latitude / 180)) +\n           (COS(PI() * [latitude] / 180) * COS(PI() * [column].latitude / 180) *\n            COS(PI() * [column].longitude / 180 - PI() * [longitude] / 180))\n       ) AS distance_to_center\nFROM [table]\nHAVING distance_to_center <= [radius] + [column].service_radius;