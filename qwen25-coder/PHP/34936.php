<?php\n$images = glob("path/to/images/*.{jpg,jpeg,png,gif}", GLOB_BRACE);\necho json_encode($images);\n?>