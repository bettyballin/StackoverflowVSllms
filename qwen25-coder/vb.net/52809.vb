Public Sub ProcessWork()\n    ThreadPool.QueueUserWorkItem(AddressOf ProcessToolWork)\nEnd Sub\n\nPrivate Sub ProcessToolWork(ByVal state As Object)\n    ' Your code here\nEnd Sub