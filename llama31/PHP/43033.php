$content = $post->post_content;\npreg_match('/src="https?:\/\/[\S\w]+"?/i', $content, $match);\nif ($match) {\n    $imageUrl = str_replace(array('src="', '"'), '', $match[0]);\n    echo '<img src="http://site/scripts/timthumb.php?src=' . urlencode($imageUrl) . '&h=320&w=214&zc=1" title="" alt="">';\n}