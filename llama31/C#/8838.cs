var uniqueItems = ddl.Items.Cast<ListItem>().Select(i => i.Text).Distinct();