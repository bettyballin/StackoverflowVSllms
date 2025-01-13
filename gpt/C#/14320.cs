using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Diagnostics;\n\npublic class TreeTraversal\n{\n    private struct Item\n    {\n        public string Text;\n        public int ID;\n        public int ParentID;\n    }\n\n    private DataTable dt;\n\n    public TreeTraversal(DataTable dataTable)\n    {\n        dt = dataTable;\n    }\n\n    private void BuildView()\n    {\n        Queue<Item> itemTree = new Queue<Item>(40);\n\n        // Get All Parent Nodes\n        DataView dv = new DataView(dt);\n        dv.RowFilter = "ParentID = 0";\n\n        // Add the parent nodes to the queue\n        foreach (DataRowView drv in dv)\n        {\n            Item item = new Item();\n            item.Text = drv["Text"].ToString();\n            item.ID = Convert.ToInt32(drv["ID"]);\n            item.ParentID = Convert.ToInt32(drv["ParentID"]);\n            itemTree.Enqueue(item);\n        }\n\n        // Go through the queue one node at a time\n        while (itemTree.Count > 0)\n        {\n            Item currentItem = itemTree.Dequeue();\n            Debug.WriteLine(currentItem.Text);\n\n            // Get children of current node\n            dv.RowFilter = String.Format("ParentID = {0}", currentItem.ID);\n            if (dv.Count > 0)\n            {\n                // Add child nodes to the queue\n                foreach (DataRowView drvChild in dv)\n                {\n                    Item item = new Item();\n                    item.Text = drvChild["Text"].ToString();\n                    item.ID = Convert.ToInt32(drvChild["ID"]);\n                    item.ParentID = Convert.ToInt32(drvChild["ParentID"]);\n                    itemTree.Enqueue(item);\n                }\n            }\n        }\n    }\n}