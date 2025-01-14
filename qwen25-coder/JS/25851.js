var preloadImages = [];\n\nfunction preload(src) {\n    if (preloadImages[src]) return;\n    var img = new Image();\n    img.src = src;\n    preloadImages[src] = img;\n}\n\npreload('images/logos/logoBlackFadedLow.jpg');\npreload('images/logos/logoWhiteFadedLow.jpg');\n\nfunction chgImg(id, sourceId) {\n    if (document.getElementById && document.images[preloadImages[sourceId]]) {\n        var imgElement = document.getElementById(id);\n        imgElement.src = preloadImages[sourceId].src;\n    }\n}