$font_file = './path/to/your/font.ttf'; // replace with your font file path\n$text = 'Hello, World!';\n$size = 24;\n\n$bbox = imageftbbox($size, 0, $font_file, $text);\nif ($bbox) {\n    // font loaded successfully, you can now use it for image generation\n} else {\n    // handle error, e.g., log the error or display a default image\n}