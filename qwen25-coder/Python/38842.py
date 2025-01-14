import math\n\n# Function to convert radians to degrees\ndef radians_to_degrees(radians):\n    return radians * (180 / math.pi)\n\n# Function to convert degrees to radians\ndef degrees_to_radians(degrees):\n    return degrees * (math.pi / 180)\n\n# Example usage\nradians = math.pi\ndegrees = 180\n\nconverted_degrees = radians_to_degrees(radians)\nconverted_radians = degrees_to_radians(degrees)\n\nprint(f"{radians} radians is {converted_degrees} degrees.")\nprint(f"{degrees} degrees is {converted_radians} radians.")