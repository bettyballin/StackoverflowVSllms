var myjson = [];\n\nfunction pass(a) {\n    myjson = a;\n\n    // Use forEach to iterate over each object in the array\n    myjson.forEach(function(item) {\n        console.log("Name: " + item.name);\n        console.log("Distance: " + item.distance);\n        console.log("Code: " + item.code);\n    });\n}