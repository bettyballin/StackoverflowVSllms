function mymodule_print_comment($comment_id) {\n  // Load the comment by its ID.\n  $comment = comment_load($comment_id);\n\n  if ($comment) {\n    // Access the comment body field.\n    $comment_body = field_get_items('comment', $comment, 'comment_body');\n    $body_value = $comment_body[0]['value'];\n\n    // Print or otherwise use the comment body.\n    print check_plain($body_value);\n  } else {\n    print "Comment not found.";\n  }\n}