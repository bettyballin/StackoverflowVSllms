require_once 'getid3/getid3.php';\n\n$getID3 = new getID3;\n$getID3->analyze($flv_file_path);\n\n$video_width = $getID3->info['video']['resolution_x'];\n$video_height = $getID3->info['video']['resolution_y'];