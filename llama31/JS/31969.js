// Secure way to bind multiple functions to a single event\n$(document).ready(function() {\n    $('#myButton').on('click', function() {\n        myFunction1();\n        myFunction2();\n        myFunction3();\n    });\n});\n\nfunction myFunction1() {\n    // Your function logic here\n    console.log('Function 1 executed');\n}\n\nfunction myFunction2() {\n    // Your function logic here\n    console.log('Function 2 executed');\n}\n\nfunction myFunction3() {\n    // Your function logic here\n    console.log('Function 3 executed');\n}