from pymdx import MdxParser\n\n   mdx_query = """\n   SELECT\n   { [Measures].[Sales Amount] } ON COLUMNS,\n   { [Date].[Calendar].[Calendar Year].Members } ON ROWS\n   FROM [Sales]\n   """\n\n   parser = MdxParser()\n   parsed_query = parser.parse(mdx_query)\n   print(parsed_query)