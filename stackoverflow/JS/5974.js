var arr = new Array();\nhtmlDoc = document;\nx = htmlDoc.documentElement.childNodes;\n\nfor (i=0,b=x.length; i<b; i++){\n  arr.push($(x[i]));  \n}