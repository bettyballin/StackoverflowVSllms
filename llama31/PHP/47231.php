$string = 'The quick brown fox jumped over the lazy dog.';\n$patterns = array('/quick/', '/lazy/', '/dog/', '/brown/', '/fox/');\n$replacements = array('slow', 'slow', 'black', 'bear');\necho preg_replace($patterns, $replacements, $string);