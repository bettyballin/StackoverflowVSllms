<?php\n\nclass Image_merger extends CI_Controller {\n    public function index() {\n        // Load the image library\n        $this->load->library('image_lib');\n\n        // Paths to our images\n        $frame_path = './path/to/frame.png'; // Your frame path\n        $photo_path = './uploads/photo.jpg';   // Uploaded photo path\n        $output_path = './uploads/photo_framed.png'; // Output file\n\n        // Load the image from the disk\n        $image_frame = imagecreatefrompng($frame_path);\n        $image_photo = imagecreatefromjpeg($photo_path);\n\n        // Get images dimensions\n        list($width_frame, $height_frame) = getimagesize($frame_path);\n        list($width_photo, $height_photo) = getimagesize($photo_path);\n\n        // Merge the images\n        // Assuming you know the positions to place the uploaded photo relative to the frame\n        imagecopymerge($image_frame, $image_photo, 50, 50, 0, 0, $width_photo, $height_photo, 100); \n\n        // Save the merged image to disk\n        imagepng($image_frame, $output_path);\n\n        // Free up memory\n        imagedestroy($image_frame);\n        imagedestroy($image_photo);\n\n        // Display or serve the new framed image if needed\n        header('Content-Type: image/png');\n        readfile($output_path);\n    }\n}