document.getElementById("list").addEventListener("click", function(event) {\n  if (event.target.tagName === "LI") {\n    var index = event.target.getAttribute("data-index");\n    foo(index);\n  }\n}, false);