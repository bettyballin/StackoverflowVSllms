function page_link_by_title($title_text) {\n    $title = Title::newFromText($title_text);\n    return '<a href="' . $title->getFullURL() . '">' . $title->getText() . '</a>';\n}