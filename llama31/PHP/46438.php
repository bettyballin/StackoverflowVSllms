preg_match('/\n    (?P<guo_match>^Guo (?P<guo_number>\d+) Cars @(?P<guo_name>\w+)) |\n    (?P<av_match>^AV (?P<av_number>\d+) Cars @(?P<av_name>\w+)) |\n    (?P<at_match>^@(?P<at_name>\w+) (?P<at_number>\d+) [#]?av)\n/i', $source, $output);