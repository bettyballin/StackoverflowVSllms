for (i = 0; i < arr.length; i++) {\n  var $element = $.xpath(arr[i]);\n  // Now you can use $element as a jQuery object\n  console.log($element.text());\n}