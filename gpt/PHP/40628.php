$input = '<p>I\'m trying to write a regular expression in PHP. From this code I want to match \'bar\'.</p>\n\n<pre><code><data info="foo">\n  "bar"|tr\n</data>\n</code></pre>\n\n<p>I tried this two regex, without success. It matches \'foo"> "bar\'.</p>\n\n<pre><code>$regex = \'/"(.*?)"\|tr/s\';\n$regex = \'/"[^"]+(.*?)"\|tr/s\';\n</code></pre>\n\n<p>Anyone can help me?</p>';\n\npreg_match('/"([^"]+)"\|tr/s', $input, $matches);\n\nif (isset($matches[1])) {\n    echo $matches[1];  // Output: bar\n}