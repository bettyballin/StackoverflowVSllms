let array = [1, 2, 3];\n        console.log(array.length); // length gives a single value, like scalar context\n        array.forEach(item => {   // iterating over an array is like list context\n            console.print(item);\n        });