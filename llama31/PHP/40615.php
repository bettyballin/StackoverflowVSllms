// Connect to MySQL database\n$conn = mysqli_connect("localhost", "username", "password", "database");\n\n// Retrieve data from database\n$result = mysqli_query($conn, "SELECT * FROM data");\n\n// Create chart\n$width = 500;\n$height = 300;\n$image = imagecreate($width, $height);\n$white = imagecolorallocate($image, 255, 255, 255);\nimagefill($image, 0, 0, $white);\n\n// Draw bars\nwhile ($row = mysqli_fetch_assoc($result)) {\n    $x = $row['x'];\n    $y = $row['y'];\n    $bar_width = 20;\n    $bar_height = $y * 10;\n    $bar_x = $x * 40;\n    $bar_y = $height - $bar_height;\n    imagefilledrectangle($image, $bar_x, $bar_y, $bar_x + $bar_width, $height, imagecolorallocate($image, 128, 128, 128));\n}\n\n// Output chart\nheader("Content-Type: image/png");\nimagepng($image);\nimagedestroy($image);