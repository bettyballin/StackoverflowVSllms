sed -i 's/<embed src="\(.*\?\)">/<a href="\1">Click here for external description<\/a>/g' your_file.csv\nawk '{gsub(/<\/?[^p][^>]*>/, "")}1' your_file.csv > output.csv\nsed -i 's/<[^>]*>//g' output.csv