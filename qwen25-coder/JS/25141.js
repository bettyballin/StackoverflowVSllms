<script language="JavaScript" type="text/javascript">\n<!--\nfunction Entry(value, name, selected) {\n    this.value = value;\n    this.name = name;\n    this.selected = selected;\n}\n\nvar productCategoryLevel2 = new Array();\nproductCategoryLevel2.push(new Entry('Hallo1', 'testix1', false));\nproductCategoryLevel2.push(new Entry('Hallo2', 'testix2', false));\nproductCategoryLevel2.push(new Entry('Hallo3', 'testix3', true));\n\nwindow.onload = function() {\n    var selectElement = document.getElementById("selSeaShells");\n\n    productCategoryLevel2.forEach(function(entry) {\n        var optL2 = document.createElement('option');\n        optL2.text = entry.name;\n        optL2.value = entry.value;\n\n        if (entry.selected) {\n            setTimeout(function() { \n                optL2.selected = true; \n            }, 0);\n        }\n\n        try {\n            selectElement.add(optL2, null); // IE uses this with the second parameter\n        } catch(ex3) {\n            selectElement.add(optL2); // standards compliant method\n        }\n    });\n};\n//-->\n</script>