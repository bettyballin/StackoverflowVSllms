$thumb = new Imagick('image.jpg');\n$thumb->resizeImage($w,$h,Imagick::FILTER_LANCZOS,1);\n$thumb->writeImage('thumb.jpg');\n$thumb->destroy(); 