$("#something").dblclick(function(){\n    if (admin && typeof adminstuff === 'function') {\n        adminstuff();\n    } else {\n        userstuff();\n    }\n});