function sub()\n{\n\n    var x=document.getElementsByName("user");\n    var nodesToChangeIndex=0;\n    var nodesToChange=new Array();\n    for (i = 0; i < x.length; i++) //for all check boxes\n    {\n        if (x[i].checked == true)\n        {\n                nodesToChange[nodesToChangeIndex++] = x[i];\n        }\n\n    }//end for\n\n    for(i=0; i < nodesToChangeIndex; i++)\n    {\n        nodesToChange[i].name="id";\n    }\n    document.checks.submit();\n\n}