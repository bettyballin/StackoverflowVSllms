GUID classId = GUID_NULL;\nif( strcmp( modelType, "Model1" ) == 0 ) {\n    classId = __uuidof( class1 );\n} else if( strcmp( modelType, "Model2" ) == 0 ) {\n    classId = __uuidof( class2 );\n} else if(... etc, continue for all possible model types\n}\nIUnitModelPtr unit;\nunit.CreateInstance( classId );\n// interface methods can be called here