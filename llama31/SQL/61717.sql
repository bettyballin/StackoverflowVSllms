TABLE ContentBase (\n  ContentId int,\n  ...\n)\n\nTABLE TextContent (\n  ContentId int,\n  Text string,\n  FOREIGN KEY (ContentId) REFERENCES ContentBase(ContentId)\n)\n\nTABLE ImageContent (\n  ContentId int,\n  Image blob,\n  FOREIGN KEY (ContentId) REFERENCES ContentBase(ContentId)\n)