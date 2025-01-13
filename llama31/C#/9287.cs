using System.Json;\n\n// Assume 'jsonData' is the JSON data received from the server\nJsonArray jsonArray = JsonArray.Parse(jsonData);\n\n// Create a ObservableCollection to bind to the DataGrid\nObservableCollection<object> data = new ObservableCollection<object>();\n\n// Iterate through the JSON array and add each item to the ObservableCollection\nforeach (JsonObject item in jsonArray)\n{\n    data.Add(item);\n}\n\n// Bind the ObservableCollection to the DataGrid\ndataGrid.ItemsSource = data;