import sys\n\ndef main(arg1, arg2):\n    print(f"Arguments received from Java: {arg1} and {arg2}")\n\nif __name__ == "__main__":\n    main(sys.argv[1], sys.argv[2])