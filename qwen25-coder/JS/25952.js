$(".x").click(function () {\n  for (var i = 0; i < 50; i++) {\n    toggleVisibility(i);\n  }\n});\n\nfunction toggleVisibility(index) {\n  var $element = $("#x" + index);\n  if ($element.is(':hidden')) {\n    $element.show();\n  } else {\n    $element.hide();\n  }\n}