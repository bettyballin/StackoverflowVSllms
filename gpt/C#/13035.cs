PdfContentByte cb = stamper.GetOverContent(pageNumber); // assuming you have a PdfStamper\nfloat mmToPoint = 0.352777778f; // 1 point = 0.352777778 mm\ncb.ConcatCTM(mmToPoint, 0, 0, mmToPoint, 0, 0);