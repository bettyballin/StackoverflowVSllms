Array = function() {\n    alert('Hi');\n};\n\nlet arr1 = [1, 2, 3, 4, 5]; // This will not alert 'Hi'\nlet arr2 = new Array(1, 2, 3, 4, 5); // This will alert 'Hi'\n\nconsole.log(arr1); // [1, 2, 3, 4, 5]\nconsole.log(arr2); // [1, 2, 3, 4, 5]