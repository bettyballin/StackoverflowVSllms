function makewindows() {\n    var child1 = window.open("", "_blank");\n    if (child1) {\n        // Ensure PHP outputs data correctly and is executed on server side\n        child1.document.write("<?php echo htmlspecialchars(json_encode($row2['ARTICLE_DESC']), ENT_QUOTES); ?>");\n        child1.document.close();\n    } else {\n        alert('Please allow popups for this website');\n    }\n}