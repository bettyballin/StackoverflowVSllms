var imageBuf = [];\nvar loadCount = 0;\nvar imgList = ["image1.jpg", "image2.jpg", "image3.jpg"]; // replace with your actual image list\n\nfunction init() {\n    $('loadStatus').update("0/" + imgList.length);\n\n    imgList.forEach(function(element, index) {\n        imageBuf[index] = new Image();\n        imageBuf[index].onload = function() {\n            count();\n        };\n        imageBuf[index].src = "thumbs/" + element;\n    });\n}\n\nfunction count() {\n    loadCount++;\n    requestAnimationFrame(function() {\n        $('loadStatus').update(loadCount + "/" + imgList.length);\n    });\n\n    if (loadCount === imgList.length) {\n        initSlideshow(); // call your function to initialize the slideshow after all images are loaded\n    }\n}\n\nfunction initSlideshow() {\n    // Your slideshow initialization code here\n    console.log("All images loaded. Initializing slideshow...");\n}\n\ninit();