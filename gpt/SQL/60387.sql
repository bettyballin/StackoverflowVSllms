ALTER TABLE Nodes\n    ADD CONSTRAINT CK_NodeType CHECK (NodeType IN ('LinkNode', 'HtmlPageNode', 'CodePageNode'));