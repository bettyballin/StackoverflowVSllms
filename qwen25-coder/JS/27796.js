function GetInputErrorCallback(errorContext) {\n    var error = errorContext.get_error();\n    if (error) {\n        $get('input_error_msg_div').innerHTML =\n            HttpUtility.htmlEncode(error.get_message());\n    }\n}