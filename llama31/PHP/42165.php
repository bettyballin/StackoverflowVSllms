function somefunc($stuff) {\n    return "my bold text <b>$stuff</b>.";\n}\n\n$awesome = somefunc("awesome");\n\n$var1 = <<<EOF\n<html lang="en">\n    <head>\n        <title>AAAHHHHH</title>\n        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">\n    </head>\n    <body>\n        $awesome\n    </body>\n</html>\nEOF;