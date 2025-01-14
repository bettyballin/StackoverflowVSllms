import pygame\nfrom pygame.locals import *\nimport random\nimport math\nimport sys\n\npygame.init()\n\nSurface = pygame.display.set_mode((800, 600))\n\ndef get_random_color():\n    return (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))\n\n# Initial background color\nbackground_color = get_random_color()\n\nCircles = []\nclass Circle:\n    def __init__(self):\n        self.radius = int(random.random() * 50) + 1\n        self.x = random.randint(self.radius, 800 - self.radius)\n        self.y = random.randint(self.radius, 600 - self.radius)\n        self.speedx = 0.5 * (random.random() + 1.0)\n        self.speedy = 0.5 * (random.random() + 1.0)\n        self.r = int(random.random() * 255) + 1\n        self.g = int(random.random() * 255) + 1\n        self.b = int(random.random() * 255) + 1\n\nfor x in range(int(random.random() * 30) + 1):\n    Circles.append(Circle())\n\ndef CircleCollide(C1, C2):\n    C1Speed = math.sqrt((C1.speedx ** 2) + (C1.speedy ** 2))\n    XDiff = -(C1.x - C2.x)\n    YDiff = -(C1.y - C2.y)\n    if XDiff > 0:\n        if YDiff > 0:\n            Angle = math.degrees(math.atan(YDiff / XDiff))\n        elif YDiff < 0:\n            Angle = math.degrees(math.atan(YDiff / XDiff))\n        XSpeed = -C1Speed * math.cos(math.radians(Angle))\n        YSpeed = -C1Speed * math.sin(math.radians(Angle))\n    elif XDiff < 0:\n        if YDiff > 0:\n            Angle = 180 + math.degrees(math.atan(YDiff / XDiff))\n        elif YDiff < 0:\n            Angle = -180 + math.degrees(math.atan(YDiff / XDiff))\n        XSpeed = -C1Speed * math.cos(math.radians(Angle))\n        YSpeed = -C1Speed * math.sin(math.radians(Angle))\n    elif XDiff == 0:\n        if YDiff > 0:\n            Angle = -90\n        else:\n            Angle = 90\n        XSpeed = C1Speed * math.cos(math.radians(Angle))\n        YSpeed = C1Speed * math.sin(math.radians(Angle))\n\n# Main game loop\nwhile True:\n    for event in pygame.event.get():\n        if event.type == QUIT:\n            pygame.quit()\n            sys.exit()\n\n    # Change background color randomly every frame\n    background_color = get_random_color()\n\n    Surface.fill(background_color)\n    \n    for circle in Circles:\n        pygame.draw.circle(Surface, (circle.r, circle.g, circle.b), (circle.x, circle.y), circle.radius)\n    \n    pygame.display.update()\n    pygame.time.delay(100)  # Adding a small delay for better visualizatio