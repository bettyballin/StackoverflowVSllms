alter table DOC_Order \nadd constraint \ndf_DOC_Order \ndefault([dbo].[NEWDOC_Order]())\nfor DOC_Order