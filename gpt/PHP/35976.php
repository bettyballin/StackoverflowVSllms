function calculateDistance($lat1, $lon1, $lat2, $lon2) {\n    // Radius of the Earth in miles\n    $earthRadius = 3960.0;\n\n    // Convert latitude and longitude from degrees to radians\n    $lat1 = deg2rad($lat1);\n    $lon1 = deg2rad($lon1);\n    $lat2 = deg2rad($lat2);\n    $lon2 = deg2rad($lon2);\n\n    // Haversine formula\n    $dlat = $lat2 - $lat1;\n    $dlon = $lon2 - $lon1;\n\n    $a = sin($dlat / 2) * sin($dlat / 2) +\n         cos($lat1) * cos($lat2) *\n         sin($dlon / 2) * sin($dlon / 2);\n\n    $c = 2 * atan2(sqrt($a), sqrt(1 - $a));\n\n    $distance = $earthRadius * $c;\n\n    return $distance;\n}\n\n// Example usage\n$lat1 = 40.7128;\n$lon1 = -74.0060;\n$lat2 = 34.0522;\n$lon2 = -118.2437;\n\necho calculateDistance($lat1, $lon1, $lat2, $lon2);