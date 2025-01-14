from tensorflow.keras.applications import VGG16\n   from tensorflow.keras.applications.vgg16 import preprocess_input\n   from tensorflow.keras.models import Model\n   import numpy as np\n\n   vgg = VGG16(weights='imagenet', include_top=False)\n   model = Model(inputs=vgg.input, outputs=vgg.get_layer('block5_conv3').output)\n\n   def fitness_function_perceptual(target_image, generated_image):\n       target_image = preprocess_input(np.expand_dims(target_image, axis=0))\n       generated_image = preprocess_input(np.expand_dims(generated_image, axis=0))\n\n       target_features = model.predict(target_image)\n       generated_features = model.predict(generated_image)\n       \n       return np.linalg.norm(target_features - generated_features)