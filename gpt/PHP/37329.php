function usethisfunction(&$thisvariable) {\n       $thisvariable += 10;\n   }\n   $a = 5;\n   usethisfunction($a);\n   echo $a; // Outputs 15