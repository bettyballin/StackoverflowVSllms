document.deepText= function(hoo, fun){\n    var A= [], tem;\n    if(hoo){\n        hoo= hoo.firstChild;\n        while(hoo!= null){\n            if(hoo.nodeType== 3){\n                if(fun){\n                    if((tem= fun(hoo))!== undefined){\n                       A[A.length]= tem;\n                    }\n                }\n                else A[A.length]= hoo;\n            }\n            else A= A.concat(arguments.callee(hoo, fun));\n            hoo= hoo.nextSibling;\n        }\n    }\n    return A;\n}