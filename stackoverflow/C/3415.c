if (PDO_PARAM_TYPE(param->param_type) == PDO_PARAM_STR && param->max_value_len <= 0 && !Z_ISNULL_P(parameter)) {\n    if (!try_convert_to_string(parameter)) {\n        return 0;\n    }\n} else if (PDO_PARAM_TYPE(param->param_type) == PDO_PARAM_INT && (Z_TYPE_P(parameter) == IS_FALSE || Z_TYPE_P(parameter) == IS_TRUE)) {\n    convert_to_long(parameter);\n} else if (PDO_PARAM_TYPE(param->param_type) == PDO_PARAM_BOOL && Z_TYPE_P(parameter) == IS_LONG) {\n    convert_to_boolean(parameter);\n}