$query = "\nSELECT\n    name, city\nFROM\n    users\nWHERE\n    latitude BETWEEN " . ($user->latitude - $radius / 69.1) . " AND " . ($user->latitude + $radius / 69.1) . "\n    AND longitude BETWEEN " . ($user->longitude - $radius / (69.1 * COS($user->latitude / 57.3))) . " AND " . ($user->longitude + $radius / (69.1 * COS($user->latitude / 57.3))) . "\n    AND (\n        (69.1 * (latitude - " . $user->latitude . ")) * \n        (69.1 * (latitude - " . $user->latitude . "))\n    ) + ( \n        (69.1 * (longitude - " . $user->longitude . ") * COS(" . $user->latitude . " / 57.3)) * \n        (69.1 * (longitude - " . $user->longitude . ") * COS(" . $user->latitude . " / 57.3))\n    ) < " . pow($radius, 2) . "\nORDER BY \n    (\n        (69.1 * (latitude - " . $user->latitude . ")) * \n        (69.1 * (latitude - " . $user->latitude . "))\n    ) + ( \n        (69.1 * (longitude - " . $user->longitude . ") * COS(" . $user->latitude . " / 57.3)) * \n        (69.1 * (longitude - " . $user->longitude . ") * COS(" . $user->latitude . " / 57.3))\n    ) ASC";