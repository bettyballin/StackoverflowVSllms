List<Service> svcs = Service.GetServices();\nList<Output> outs = Output.GetOutputs();\n\n// Attach the Output objects to the data context of the Service objects\nforeach (var output in outs)\n{\n    svcs[0].DataContext.Attach(output, true);\n}\n\nsvcs[0].OutputCollection.Add(outs);\nsvcs[0].Save();