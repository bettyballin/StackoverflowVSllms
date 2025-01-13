// Default export is a4 paper, portrait, using milimeters for units
\nvar doc = new jsPDF()
\n
\ndoc.text('Hello world!', 10, 10)
\ndoc.save('a4.pdf')