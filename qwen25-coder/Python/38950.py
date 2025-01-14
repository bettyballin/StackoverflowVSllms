from PIL import Image\nimport mss\n\ndef capture_screen(region):\n    # region = {'top': 100, 'left': 100, 'width': 200, 'height': 300}\n    with mss.mss() as sct:\n        screenshot = sct.shot(mon=region)\n        img = Image.open(screenshot)\n        return img\n\n# Example usage\nimg = capture_screen({'top': 100, 'left': 100, 'width': 200, 'height': 300})\npixel_value = img.getpixel((x, y))  # Get pixel value at (x, y)