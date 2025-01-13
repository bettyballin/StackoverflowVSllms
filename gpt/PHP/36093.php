use Drupal\comment\Entity\Comment;\n\n// Load the comment by its ID\n$comment_id = 123; // Replace with the actual comment ID\n$comment = Comment::load($comment_id);\n\nif ($comment) {\n  // Render the comment\n  $comment_rendered = \Drupal::entityTypeManager()\n    ->getViewBuilder('comment')\n    ->view($comment);\n\n  print render($comment_rendered);\n} else {\n  print "Comment not found.";\n}