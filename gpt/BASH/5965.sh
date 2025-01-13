# Step 1: Export articles from Wikipedia\n# Create a file with a list of Wikipedia article titles (e.g., articles.txt)\n# Use wget or curl to batch export these articles\n\nwget --post-data 'pages=Page1\nPage2\nPage3' -O exported.xml "https://en.wikipedia.org/wiki/Special:Export"\n\n# Step 2: Import the exported articles to your MediaWiki site\n# Make sure to place exported.xml in your MediaWiki maintenance directory\n\ncd /path/to/your/mediawiki/maintenance\nphp importDump.php --prefix "imported_" /path/to/exported.xml