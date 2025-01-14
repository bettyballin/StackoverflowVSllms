import random\n\ndef get_random_images(image_list, num_images=5):\n    if num_images > len(image_list):\n        raise ValueError("Number of images requested exceeds the list size.")\n    return random.sample(image_list, num_images)\n\n# Example usage:\nimages = [\n    'image1.jpg', 'image2.jpg', 'image3.jpg',\n    'image4.jpg', 'image5.jpg', 'image6.jpg',\n    'image7.jpg', 'image8.jpg', 'image9.jpg'\n]\n\nrandom_images = get_random_images(images)\nprint("Randomly selected images:", random_images)