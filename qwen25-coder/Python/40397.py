try:\n       from bs4 import BeautifulSoup\n       print("BeautifulSoup is installed successfully.")\n   except ImportError:\n       print("BeautifulSoup is not installed. Please install using pip install beautifulsoup4.")