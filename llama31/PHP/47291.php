$text = '<img src="image1.jpg" /><img src="image2.jpg" />';\n$images = get_images($text);\nprint_r($images); // Output: Array ( [0] => image1.jpg [1] => image2.jpg )