function load(y) {\n       $.ajax({\n           url: y,\n           type: 'GET',\n           processData: false,\n           success: function(rawData) {\n               var decoder = new TextDecoder('ISO-8859-15');\n               var decodedString = decoder.decode(new Uint8Array(rawData));\n               $("#replace").html(decodedString);\n               mod();\n           },\n           dataType: 'arraybuffer' // raw bytes of data\n       });\n   }