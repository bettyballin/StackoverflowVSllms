$content = "Your string with <img src='image.jpg'> some text.";\n$content = preg_replace("/<img[^>]+\>/i", "", $content);\necho $content;