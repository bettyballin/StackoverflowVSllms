var o = $get('myTextBox');\n$addHandler(o, 'click', function(event) {\n    funcWithArgs('param1', 'param2', event);\n});