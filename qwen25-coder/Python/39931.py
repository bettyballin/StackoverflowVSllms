from pynput import keyboard\nimport select\n\n# This will hold incoming keyboard presses\nkeys_pressed = set()\n\ndef on_press(key):\n    try:\n        keys_pressed.add(key.char)\n    except AttributeError:\n        pass  # ignore special keys (e.g., shift, ctrl)\n\ndef on_release(key):\n    if key in keys_pressed:\n        keys_pressed.remove(key)\n    if key == keyboard.Key.esc:  # stop listener when ESC is pressed\n        return False\n\n# Set up the listener to monitor keyboard events\nlistener = keyboard.Listener(on_press=on_press, on_release=on_release)\nlistener.start()\n\ndef do_other_io():\n    print("Doing amazing pythonic embedded stuff")\n\nwhile True:\n    do_other_io()\n    \n    # Check if any key was pressed\n    if keys_pressed:\n        for key in list(keys_pressed):  # iterate over a copy of the set\n            print(f"Key {key} pressed")\n            keys_pressed.remove(key)  # clear handled keys\n    \n    # Use select to manage other I/O operations non-blocking\n    r, w, x = select.select([sys.stdin], [], [], 0.1)\n    if sys.stdin in r:\n        line = sys.stdin.readline()\n        if line:\n            print(f"Read from stdin: {line.strip()}")\n\n# The listener will stop when we stop the main loop or ESC is pressed\nlistener.stop()