DECLARE\n    -- Define subtypes based on your desired types\n    SUBTYPE AttrType IS VARCHAR2(40);\n    SUBTYPE ValType  IS VARCHAR2(2000);\n    SUBTYPE InstType IS NUMBER(4);\n\n    -- Use subtypes in your record definition\n    TYPE AttrValueRec IS RECORD (\n        attr AttrType,\n        val  ValType,\n        inst InstType\n    );\n\n    -- Now you can use these subtypes in your function parameters\n    FUNCTION create_attrval(attr AttrType, \n                            val  ValType, \n                            inst InstType := 1)\n    RETURN AttrValueRec IS\n        attr_value AttrValueRec;\n    BEGIN\n        attr_value.attr := attr;\n        attr_value.val := val;\n        attr_value.inst := inst;\n        RETURN attr_value;\n    END;\n\nBEGIN\n    NULL;\nEND;