$text = "AB ABC D";\n$text = preg_replace('/A([^A]*)C/', 'foo$1bar', $text);\necho $text;