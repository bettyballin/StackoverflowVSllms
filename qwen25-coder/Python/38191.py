import turtle\n\ndef apply_rules(axiom, rules, iterations):\n    result = axiom\n    for _ in range(iterations):\n        new_result = ""\n        for char in result:\n            if char in rules:\n                new_result += rules[char]\n            else:\n                new_result += char\n        result = new_result\n    return result\n\ndef draw_l_system(commands, angle, distance, start_x, start_y):\n    screen = turtle.Screen()\n    screen.setup(width=800, height=600)\n    t = turtle.Turtle()\n    t.speed(0)\n    t.penup()\n    t.goto(start_x, start_y)\n    t.pendown()\n    \n    stack = []\n    for command in commands:\n        if command == 'F':\n            t.forward(distance)\n        elif command == '+':\n            t.right(angle)\n        elif command == '-':\n            t.left(angle)\n        elif command == '[':\n            stack.append((t.pos(), t.heading()))\n        elif command == ']':\n            pos, heading = stack.pop()\n            t.penup()\n            t.goto(pos)\n            t.setheading(heading)\n            t.pendown()\n\n    screen.mainloop()\n\n# Define the axiom and rules of your L-System\naxiom = "F"\nrules = {"F": "F[+F]F[-F]F"}\niterations = 2\n\ncommands = apply_rules(axiom, rules, iterations)\n\n# Draw the result\ndraw_l_system(commands, angle=30, distance=15, start_x=-400, start_y=-300)