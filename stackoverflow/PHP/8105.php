$string = '<!-- LoginStart --><div id="stuff">text</div><!-- LoginEnds -->';\n$regex = '#<!--\s*LoginStart\s*-->(.*?)<!--\s*LoginEnds\s*-->#s';\n\npreg_match($regex, $string, $matches);\n\nprint_r($matches); // $matches[1] = <div id="stuff">text</div>