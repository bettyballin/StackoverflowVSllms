function Validate() {\n    var i = 1;\n    var output = '';\n\n    do {\n        var radioButton = document.getElementById('radioButtonAnswer2');\n        output += (radioButton == null) + ' ';\n        i++;\n    } while (i < 10);\n\n    console.log(output);\n    console.log('out of loop');\n\n    return false;\n}