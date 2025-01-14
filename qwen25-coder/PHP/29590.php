function getBestThumbnail(array $image_array): ?string {\n    foreach ($image_array as $filepath) {\n        if (strpos($filepath, '-large') !== false) {\n            return $filepath; // Rule 1: Return immediately if "-large" is found.\n        }\n        \n        list($width,) = @getimagesize($filepath); // Get image width.\n        \n        if ($width === 260) {\n            return $filepath; // Rule 2: Next best match.\n        }\n        \n        if ($width === 265) {\n            return $filepath; // Rule 3: Continue checking in order of preference.\n        }\n        \n        if ($width === 600) {\n            return $filepath; // Rule 4\n        }\n        \n        if ($width === 220) {\n            return $filepath; // Rule 5\n        }\n    }\n    \n    return null; // Return null if no image matches any criteria.\n}\n\n// Example usage:\n$image_array = ['image1.jpg', 'photo-large.jpg', 'pic-260px.jpg'];\n$thumbnail = getBestThumbnail($image_array);\n\nif ($thumbnail) {\n    echo "The best thumbnail is: " . $thumbnail;\n} else {\n    echo "No suitable image found.";\n}