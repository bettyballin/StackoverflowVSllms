<?php\nfunction somefunc($stuff) {\n    return "my bold text <b>{$stuff}</b>.";\n}\n\n// Prepare dynamic content\n$part1 = somefunc("is awesome!");\n$part2 = somefunc("is actually not so awesome..");\n$part3 = somefunc("will work now!");\n\n// Use the prepared parts in your HEREDOC string\n$var1 = <<<EOF\n    <html lang="en">\n        <head>\n            <title>AAAHHHHH</title>\n            <meta http-equiv="Content-Type" content="text/html;charset=utf-8">\n        </head>\n        <body>\n            $part1 \n            $part2 \n            $part3\n        </body>\n    </html>\nEOF;\n\necho $var1;\n?>