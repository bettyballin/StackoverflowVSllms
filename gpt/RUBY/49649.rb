ruby -e '`pdftk #{Dir["[0-9][0-9]_*"].sort.join(" ")} output combined.pdf`'