SELECT n.* \nFROM Node n\nJOIN Closure c ON n.NodeId = c.DescendantId\nWHERE c.AncestorId = @TargetNodeId;