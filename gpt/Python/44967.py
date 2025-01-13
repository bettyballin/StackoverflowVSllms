import cv2\n   from skimage.metrics import structural_similarity as ssim\n\n   def compute_ssim(imageA, imageB):\n       # Convert images to grayscale\n       grayA = cv2.cvtColor(imageA, cv2.COLOR_BGR2GRAY)\n       grayB = cv2.cvtColor(imageB, cv2.COLOR_BGR2GRAY)\n       \n       # Compute SSIM between the two images\n       score, diff = ssim(grayA, grayB, full=True)\n       \n       return score, diff\n\n   # Example usage\n   imageA = cv2.imread('image1.jpg')\n   imageB = cv2.imread('image2.jpg')\n\n   score, diff = compute_ssim(imageA, imageB)\n   print(f"SSIM: {score}")