$(document).ready(function() {\n       $('#my-image').imgAreaSelect({\n           aspectRatio: '4:3', // Optional: enforce aspect ratio\n           onSelectEnd: function(img, selection) {\n               console.log('Selection coordinates:', selection);\n               // You can send these coordinates to your Rails backend using AJAX\n           }\n       });\n   });