# Replace <embed src="..."> with <a href="...">\nsed -E 's/<embed src="([^"]+)"><\/embed>/<a href="\1">Click here for external description<\/a>/g' input.html |\n\n# Remove all HTML tags except <p>\nsed -E 's/<[^p>][^>]*>//g'