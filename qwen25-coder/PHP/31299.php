$distance = -1; //default\n// distance calc\nif ($dgalaxy == $galaxy) { // Change '=' to '=='\n    if (($dx = $x) && ($dy = $y)) {\n        // inter planetary currently unknown formula\n    } else {\n        $distance = round(sqrt(pow(($dx - $x), 2) + pow(($dy - $y), 2))); // interstellar\n    }\n} else { // intergalatic\n    if ($galaxy < $dgalaxy) {\n        $distance = (((9 - fmod($galaxy, 10)) * 200) + 2000 + (fmod($dgalaxy, 10) * 200)); // anti clockwise galactic\n    } else {\n        $distance = (((fmod($galaxy, 10)) * 200) + 2000 + (fmod(9 - $dgalaxy, 10) * 200)); // clockwise galactic\n    }\n}