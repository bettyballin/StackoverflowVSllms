using System;\nusing System.IO;\nusing System.Security.Cryptography.X509Certificates;\nusing iTextSharp.text;\nusing iTextSharp.text.pdf;\nusing Org.BouncyCastle.X509;\n\npublic string Sign(string SigReason, string SigContact, string SigLocation, bool visible)\n{\n    string bugLog = "";\n    try\n    {\n        using (PdfReader reader = new PdfReader(this.inputPDF))\n        using (FileStream fs = new FileStream(this.outputPDF, FileMode.Create, FileAccess.Write))\n        using (PdfStamper st = PdfStamper.CreateSignature(reader, fs, '\0', null, true))\n        {\n            st.MoreInfo = this.metadata.getMetaData();\n            st.XmpMetadata = this.metadata.getStreamedMetaData();\n\n            PdfSignatureAppearance sap = st.SignatureAppearance;\n            sap.SetCrypto(this.myCert.Akp, this.myCert.Chain, null, PdfSignatureAppearance.WINCER_SIGNED);\n            sap.Reason = SigReason;\n            sap.Contact = SigContact;\n            sap.Location = SigLocation;\n\n            if (visible)\n            {\n                sap.SetVisibleSignature(new Rectangle(100, 100, 250, 150), 1, null);\n            }\n        }\n    }\n    catch (Exception e)\n    {\n        bugLog += " ERROR Sign: " + e.Message;\n    }\n\n    return bugLog;\n}\n\nprivate void processCert(X509Certificate2 card)\n{\n    X509CertificateParser cp = new X509CertificateParser();\n    X509Certificate cert = cp.ReadCertificate(card.RawData);\n    chain = new X509Certificate[] { cert };\n}