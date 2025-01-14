from bs4 import BeautifulSoup\n\n# Load and parse the HTML file\nwith open('tidied_output.xhtml', 'r') as file:\n    soup = BeautifulSoup(file, 'html.parser')\n\n# Check and move comments if necessary\nfor comment in soup.find_all(string=lambda text: isinstance(text, Comment)):\n    if "BODY_ON_LOAD_SECTION" in comment:\n        # Move the comment where you want it\n        pass\n\n# Save the adjusted HTML\nwith open('final_output.xhtml', 'w') as file:\n    file.write(str(soup))