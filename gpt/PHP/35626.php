function minifyHtml($html) {\n       return preg_replace(['/<!--.*?-->|\t|(?:\r?\n[ \t]*)+/s', '/^\\s+|\\s+$/m'], ['', ''], $html);\n   }\n\n   ob_start();\n   ?>\n   <div class="foo">\n       <?php\n       $fooHeader();\n       $fooBody();\n       $fooFooter();\n       ?>\n   </div>\n   <?php\n   $output = ob_get_clean();\n   echo minifyHtml($output);