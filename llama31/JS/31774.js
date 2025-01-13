function doLoadThumbnails(queue) {\n  var imageLink = queue.dequeue();\n  var loader = new Image();\n  loader.onload = function() {\n    imageLink.firstChild.src = imageLink.href;\n    // trigger the next image load\n    if (!queue.isEmpty()) {\n      doLoadThumbnails(queue);\n    }\n  };\n  loader.src = imageLink.href;\n}\n\n// create a queue and add all the image links to it\nvar queue = new Queue();\n// ...\n\n// start loading the thumbnails\ndoLoadThumbnails(queue);