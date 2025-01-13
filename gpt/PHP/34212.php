// captcha.php\n   header("Content-type: image/png");\n\n   class Captcha  {\n       // some attributes bla bla\n       \n       public function __construct($new_string_length, $new_width_picture, $new_height_picture, $new_string_color) {\n           $this->string_length = $new_string_length;\n           $this->width_picture = $new_width_picture;\n           $this->height_picture = $new_height_picture;\n           $this->string_color = $new_string_color;\n           $this->string = '';\n       }\n\n       public function getString() {\n           return $this->string;\n       }\n\n       public function generateRandomString() {\n           $str = "";\n           $basket = "abcdefghijklmnopqrstuvwxyz0123456789";\n           $basket_length = strlen($basket);\n           srand((double) microtime() * 1000000);\n           for($i=0;$i<$this->string_length;$i++) {\n               $generated_pos = rand(0, $basket_length-1);\n               $str_substr = $basket[$generated_pos];\n               if(!is_numeric($str_substr)) {\n                   if(rand(0,1) == 1) {\n                       $str_substr = strtoupper($str_substr);\n                   }\n               }\n               $str .= $str_substr;\n           }\n           $this->string = $str;\n       }\n\n       public function generatePictureFromString($new_string) {\n           $root_fonts = '../fonts/';\n           $list_fonts = array('ABODE.ttf', 'acme.ttf', 'Alcohole.ttf', 'Anarchistica.ttf', 'AMERIKAA.ttf');\n\n           $image = imagecreatetruecolor($this->width_picture, $this->height_picture);\n           $black = imagecolorallocate($image, 0, 0, 0);\n           $clr = explode('/', $this->string_color);\n           $clr = imagecolorallocate($image, $clr[0], $clr[1], $clr[2]);\n\n           $font_path = $root_fonts . $list_fonts[array_rand($list_fonts)];\n\n           for($i=0; $i<strlen($new_string); $i++) {\n               imagettftext(\n                   $image,\n                   rand(($this->height_picture / 4.3), ($this->height_picture) / 4.2),\n                   rand(-45, 45),\n                   ($this->width_picture) / (5 * $this->string_length) + ($this->width_picture) / ($this->string_length) * $i,\n                   0.6 * ($this->height_picture),\n                   $clr,\n                   $font_path,\n                   $new_string[$i]\n               );\n           }\n\n           imagepng($image);\n           imagedestroy($image);\n       }\n   }