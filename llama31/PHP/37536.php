$search_terms = array('foo', 'bar');\n$text = 'This is a foo bar example.';\n$highlighted_text = highlight_search_terms($text, $search_terms);\necho $highlighted_text; // Output: This is a <span class="highlight">foo</span> <span class="highlight">bar</span> example.