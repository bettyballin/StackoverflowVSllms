using NPOI.HWPF;\nusing NPOI.HWPF.Extractor;\nusing NPOI.POIFS.FileSystem;\nusing NPOI.HSLF.UserModel;\nusing NPOI.HSLF.Extractor;\n\npublic string ExtractTextFromDoc(string filepath)\n{\n    POIFSFileSystem fs = new POIFSFileSystem(new FileStream(filepath, FileMode.Open, FileAccess.Read));\n    WordExtractor extractor = new WordExtractor(fs);\n    return extractor.Text;\n}\n\npublic string ExtractTextFromPpt(string filepath)\n{\n    HSLFSlideShow ppt = new HSLFSlideShow(new POIFSFileSystem(new FileStream(filepath, FileMode.Open, FileAccess.Read)));\n    PowerPointExtractor extractor = new PowerPointExtractor(ppt);\n    return extractor.Text;\n}