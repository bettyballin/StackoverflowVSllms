function makewindows() {\n    let child1 = window.open("about:blank", '_blank');\n    if (child1) {\n        child1.document.write(<?= json_encode($row2["ARTICLE_DESC"], JSON_HEX_TAG | JSON_HEX_APOS); ?>);\n        child1.document.close();\n    }\n}