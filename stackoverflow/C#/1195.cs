from a in dbReqs\ngroup a by new { a.AssignmentID, a.StopID }\ninto pr\nselect new\n{\n  AssignmentID = pr.Key.AssignmentID,\n  StopID = pr.Key.StopID,\n  PickQty = pr.Sum(p=> p.PickedQty),\n  Count = pr.Sum(c => c.ReqQty)\n}