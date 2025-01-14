require 'combine_pdf'\n\n# Load the existing PDF\npdf = CombinePDF.load('document.pdf')\n\n# Iterate over each page and save as individual files\npdf.pages.each_with_index do |page, index|\n  new_pdf = CombinePDF.new\n  new_pdf << page\n  File.open("page_#{index+1}.pdf", "wb") { |f| f.write(new_pdf.to_pdf) }\nend