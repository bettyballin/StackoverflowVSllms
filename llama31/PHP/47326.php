$attributeRegexp = '/(\S+)=["\']?((?:.(?!["\']?\s+(?:\S+)=|[>"\']))+.)["\']?/';\n$attributeMatches = null;\npreg_match_all($attributeRegexp, $matches[1][2], $attributeMatches);\n\nprint_r($attributeMatches);