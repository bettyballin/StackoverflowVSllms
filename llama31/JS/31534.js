for (i = 0; i < elem.length; i++) {\n  if (elem[i].rel == "litebox") {\n    let imgSource = elem[i].href.toString();\n    let imgTitle = elem[i].title;\n    elem[i].childNodes[0].style.border = "0px solid #fff";\n    elem[i].onclick = function () {\n      liteBoxFocus(imgSource, imgTitle);\n      return false;\n    };\n  }\n}