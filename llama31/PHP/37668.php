$uploadTempFile = $myField[ 'tmp_name' ];\nlist( $uploadWidth, $uploadHeight, $uploadType ) = getimagesize( $uploadTempFile );\n\n$srcImage = imagecreatefrompng( $uploadTempFile );\n\n$targetImage = imagecreatetruecolor( 128, 128 );\nimagealphablending( $targetImage, false );\nimagesavealpha( $targetImage, true );\n\nimagecopyresampled( $targetImage, $srcImage,\n                    0, 0,\n                    0, 0,\n                    128, 128,\n                    $uploadWidth, $uploadHeight );\n\nimagepng(  $targetImage, 'out.png', 9 );