import pyPdf                                                                \npdf = pyPdf.PdfFileReader(open("file.pdf"))\npdf.decrypt("password")