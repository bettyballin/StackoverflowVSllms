if ($_FILES['imagefile']['type'] == "image/png") {\n    imagepng($dimg, "$tdir" . "thumb_" . $fdate . "$file_ext");\n} elseif ($_FILES['imagefile']['type'] == "image/gif") {\n    imagegif($dimg, "$tdir" . "thumb_" . $fdate . "$file_ext");\n} else {\n    imagejpeg($dimg, "$tdir" . "thumb_" . $fdate . "$file_ext");\n}