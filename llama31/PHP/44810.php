function compare_label($a, $b) {\n    return strnatcmp($a['label'], $b['label']);\n}\n\n// Later, in the same scope\nusort($label, 'compare_label');