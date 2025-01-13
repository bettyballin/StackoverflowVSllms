<?php\nini_set('memory_limit', '128M'); // Increase memory limit\n\nmove_uploaded_file($_FILES['image']['tmp_name'], $mainframe->getCfg('absolute_path') . "/virtualgallery/images/resize/$newname");\n\n/* resize images - width 600px */\n$docRoot = $GLOBALS['mosConfig_absolute_path'];\n$pathToImages = $docRoot . '/virtualgallery/images/resize/';\n$pathToThumbs = $docRoot . '/virtualgallery/images/';\n$thumbHeight = 600;\n\n$dir = opendir($pathToImages);\nwhile (false !== ($fname = readdir($dir))) {\n    $info = pathinfo($pathToImages . $fname);\n    if (strtolower($info['extension']) == 'jpg') {\n        $img = imagecreatefromjpeg("{$pathToImages}{$fname}");\n        if ($img) {\n            $width = imagesx($img);\n            $height = imagesy($img);\n            $new_width = floor($width * ($thumbHeight / $height));\n            $new_height = $thumbHeight;\n            $tmp_img = imagecreatetruecolor($new_width, $new_height);\n            if ($tmp_img) {\n                imagecopyresampled($tmp_img, $img, 0, 0, 0, 0, $new_width, $new_height, $width, $height);\n                imagejpeg($tmp_img, "{$pathToThumbs}{$fname}");\n                imagedestroy($tmp_img);\n            }\n            imagedestroy($img);\n        }\n    }\n}\nclosedir($dir);\n\n/* delete file(s) from resize folder */\n$dir = $docRoot . '/virtualgallery/images/resize/';\nforeach (glob($dir . '*.*') as $v) {\n    unlink($v);\n}\n?>