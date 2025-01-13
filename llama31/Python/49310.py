import atexit\nimport signal\nimport sys\n\ndef last_function():\n    # Your last command here\n    print("Running one last command before exiting.")\n\n# Register the function to be executed at exit\natexit.register(last_function)\n\n# Catch SIGINT (keyboard interrupt) and SIGTERM (termination) signals\ndef signal_handler(sig, frame):\n    sys.exit(0)\n\nsignal.signal(signal.SIGINT, signal_handler)\nsignal.signal(signal.SIGTERM, signal_handler)\n\n# Rest of your script here...\nwhile True:\n    pass