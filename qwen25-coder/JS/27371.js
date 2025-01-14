function shuffleArray(array) {\n    let currentIndex = array.length, temporaryValue, randomIndex;\n\n    // While there remain elements to shuffle...\n    while (0 !== currentIndex) {\n\n        // Pick a remaining element...\n        randomIndex = Math.floor(Math.random() * currentIndex);\n        currentIndex -= 1;\n\n        // And swap it with the current element.\n        temporaryValue = array[currentIndex];\n        array[currentIndex] = array[randomIndex];\n        array[randomIndex] = temporaryValue;\n    }\n\n    return array;\n}\n\nlet images = ['img1', 'img2', 'img3', 'img4', 'img5', 'img6', \n              'img7', 'img8', 'img9', 'img10', 'img11', 'img12',\n              'img13', 'img14', 'img15', 'img16', 'img17', 'img18'];\n\n// Shuffle the images\nlet shuffledImages = shuffleArray(images);\n\n// Get the first 12 images from the shuffled array\nlet selectedImages = shuffledImages.slice(0, 12);\n\nconsole.log(selectedImages);