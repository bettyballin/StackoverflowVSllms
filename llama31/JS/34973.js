var baitImg = new Image();\nbaitImg.onload = function() {\n  console.log('Ad blocker not detected');\n};\nbaitImg.onerror = function() {\n  console.log('Ad blocker detected');\n};\nbaitImg.src = 'path_to_bait_image.jpg';