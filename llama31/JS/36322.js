// Include pdf.js library\n<script src="https://cdn.jsdelivr.net/npm/pdfjs-dist@2.7.570/build/pdf.min.js"></script>\n\n// Load the PDF file\npdfjsLib.getDocument('path/to/your/pdf/file.pdf').promise.then(function(pdf) {\n  // Render the PDF in HTML\n  var pdfViewer = new pdfjsViewer.PDFSinglePageViewer({\n    container: document.getElementById('pdf-container')\n  });\n  pdfViewer.setDocument(pdf);\n});