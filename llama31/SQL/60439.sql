declare @xml xml = '<root><!-- comment 1 --><element /><!-- comment 2 --></root>'\nset @xml.modify('delete comment()')\nselect @xml