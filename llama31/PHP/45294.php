function processYouTubeVideos($str) {\n    $url = parse_url($str);\n    parse_str($url['query'], $params);\n    $video_id = $params['v'];\n    return $video_id;\n}