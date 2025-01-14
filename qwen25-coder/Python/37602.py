from PIL import Image, ImageDraw, ImageFont\n\ndef create_text_image(text, outputPath):\n    # Create an image with white background\n    image = Image.new('RGB', (400, 100), color='white')\n    draw = ImageDraw.Draw(image)\n    \n    # Load a recommended font\n    try:\n        # You need to have the DejaVuSansMono-Bold.ttf font file available in your path\n        font = ImageFont.truetype("DejaVuSansMono-Bold.ttf", 40)\n    except IOError:\n        font = ImageFont.load_default()  # Fallback if font is not found\n    \n    # Draw text on image\n    draw.text((10, 25), text, fill='black', font=font)\n    \n    # Save the image\n    image.save(outputPath)\n\n# Example usage\ncreate_text_image("Your ID Text Here", "id.png")