try {\n    $str = core_wp('foo_shortcode', $post->post_content);\n} catch (Exception $e) {\n    error_log('Caught exception: ' . $e->getMessage());\n}