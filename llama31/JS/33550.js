function limitRootNodes() {\n  var tree_ul = $('#Tree ul li ul:first').children();\n  var max_listCount = 3;\n  tree_ul.slice(max_listCount).remove();\n}