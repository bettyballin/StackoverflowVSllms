$template = "<html><head><title>{the_title}</title></body><body>{the_content}</body></html>";\n\n$title = htmlspecialchars($some_runtime_generated_title, ENT_QUOTES, 'UTF-8');\n$content = htmlspecialchars($some_runtime_generated_content, ENT_QUOTES, 'UTF-8');\n\n$output = str_replace('{the_title}', $title, $template);\n$output = str_replace('{the_content}', $content, $output);\n\necho $output;