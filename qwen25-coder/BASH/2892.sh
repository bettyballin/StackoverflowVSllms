# Step 1: Get an edit token using a query\nTOKEN=$(curl -s "https://your-wiki.example.com/w/api.php?action=query&prop=info&titles=Main_Page&intoken=edit&format=json" \\n| jq -r '.query.pages[] | .edittoken')