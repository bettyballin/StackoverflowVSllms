SELECT ?husband ?color WHERE {\n  ?husband <spouse> ?wife .\n  ?husband <likes> ?color .\n  MINUS { ?wife <likes> ?color }\n}