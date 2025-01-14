import random\n\nLOREM_IPSUM = (\n    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "\n    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "\n    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "\n    "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."\n).split()\n\ndef generate_lorem_ipsum(word_count):\n    return ' '.join(random.choices(LOREM_IPSUM, k=word_count))\n\nif __name__ == "__main__":\n    import sys\n    try:\n        word_count = int(sys.argv[1])\n    except (IndexError, ValueError):\n        print("Usage: python lorem.py <number_of_words>")\n    else:\n        print(generate_lorem_ipsum(word_count))