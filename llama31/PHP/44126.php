$string = "this is a %f sample %'-20s, this string is mixed with type specifier like (number:%d's)";\n$pattern = '/%[+-]? ?#*\.?[0-9]*[a-z]/';\n\necho preg_replace($pattern, '[#]', $string);