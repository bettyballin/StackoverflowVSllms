DataServiceQuery<Insurance.Claims> dataServiceQuery = \n    claim as DataServiceQuery<Insurance.Claims>;\n\ndataServiceQuery.BeginExecute((asyncResult) =>\n{\n    results = dataServiceQuery.EndExecute(asyncResult).ToList();\n    \n    if (results == null)\n    {\n        // Handle error\n    }\n    else\n    {\n        // Populate Silverlight dropdown with all entries, including duplicates\n        Dispatcher.BeginInvoke(() => \n        {\n            dropdownList.ItemsSource = results.Select(c => c.CodeName);\n        });\n    }\n});