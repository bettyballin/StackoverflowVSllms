SELECT images.*\nFROM images\nJOIN productPhotos ON images.imageID = productPhotos.imageID\nWHERE productPhotos.productID IN (5, 2, 4)\nORDER BY FIELD(productPhotos.productID, 5, 2, 4);