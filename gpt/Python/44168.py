import jpype\nimport jpype.imports\nfrom jpype.types import *\n\njpype.startJVM(classpath=['boilerpipe-1.2.0.jar'])\n\nfrom de.l3s.boilerpipe.extractors import ArticleExtractor\n\ndef extract_main_content_using_boilerpipe(url):\n    extractor = ArticleExtractor.INSTANCE\n    content = extractor.getText(url)\n    return content\n\n# Example usage\nurl = "https://example.com"\nmain_content = extract_main_content_using_boilerpipe(url)\nprint(main_content)\n\njpype.shutdownJVM()