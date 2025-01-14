//process things for fiber map\njQuery(document).ready(function() {\n    var ringType = new Array();\n\n    //populate and display ringType\n    $.ajax({\n        type: "GET",\n        url: "ajaxHelper.pl",\n        data: {\n            getRingTypes: "1",\n        },\n        dataType: "xml",\n        success: function(xml) {\n            //if the query was successful,\n            console.log("Got an xml object:", $(xml));\n            $(xml).find("ringType").each(function() {\n                var type = $(this).text(); //save the value\n                //append to ringType array\n                ringType.push(type);\n            });\n            \n            //output the results after processing XML\n            console.log('Ring Types:', ringType);\n        },\n        error: function(xhr, ajaxOptions, thrownError) {\n            console.error("Error occurred:", xhr.status, ajaxOptions, thrownError);\n        }\n    });\n\n    // Delay this block to ensure the AJAX response has been processed\n    setTimeout(function() {\n        if (ringType.length > 0) {\n            for (var i = 0; i < ringType.length; i++) {\n                document.write("<br>" + ringType[i]);\n            }\n        } else {\n            console.error("No ring types received.");\n        }\n    }, 2000); // Adjust the timeout as necessary\n});