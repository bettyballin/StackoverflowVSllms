function all_images(&$post) {\n    $content = $post->post_content;\n    if (preg_match_all('/<img[^>]+src="(.*?)"[^>]*>/', $content, $results)) {\n        foreach ($results[1] as $result) {\n            echo $result . "<br>";\n        }\n    }\n}