Public Function AfterReceiveRequest(ByRef request As System.ServiceModel.Channels.Message, ByVal channel As System.ServiceModel.IClientChannel, ByVal instanceContext As System.ServiceModel.InstanceContext) As Object Implements System.ServiceModel.Dispatcher.IDispatchMessageInspector.AfterReceiveRequest\n    'Output the request message to immediate window\n    System.Diagnostics.Debug.WriteLine("*** SERVER - RECEIVED REQUEST ***")\n    System.Diagnostics.Debug.WriteLine(request.ToString())\n\n    Return Nothing\nEnd Functio