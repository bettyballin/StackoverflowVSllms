var o = $get('myTextBox');\n\nfunction funcWithArgs(arg1, arg2, event) {\n    // Your function logic here\n    console.log(arg1, arg2, event);\n}\n\nvar arg1 = 'value1';\nvar arg2 = 'value2';\n\n$addHandler(o, 'click', function(event) {\n    funcWithArgs(arg1, arg2, event);\n});