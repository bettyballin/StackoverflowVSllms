ini_set("memory_limit","30M");\n\nif(isset($_POST['submit'])){\n    if (isset ($_FILES['new_image'])){\n        $imagename = $_FILES['new_image']['name'];\n        $source = $_FILES['new_image']['tmp_name'];\n        $target = "images/".$imagename;\n        move_uploaded_file($source, $target);\n\n        $imagepath = $imagename;\n\n        $save = "thumbs/uploads/" . $imagepath; \n        $file = "images/" . $imagepath; \n\n        list($width, $height) = getimagesize($file);\n\n        $modwidth = 150; \n        $modheight = 150; \n\n        if($width > $height){\n            $modheight = $height * ($modwidth / $width);\n        } else {\n            $modwidth = $width * ($modheight / $height);\n        }\n\n        $tn = imagecreatetruecolor($modwidth, $modheight); \n        $image = imagecreatefromjpeg($file); \n\n        imagecopyresampled($tn, $image, 0, 0, 0, 0, $modwidth, $modheight, $width, $height); \n\n        imagedestroy($image);\n\n        imagejpeg($tn, $save, 100); \n\n        imagedestroy($tn);\n    }\n}