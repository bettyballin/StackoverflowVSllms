do\n    let reader = new XmlTextReader("url")\n    let doc = new XmlDocument()\n    doc.Load(reader)\n    // 'reader' and 'doc' are only in scope within this block