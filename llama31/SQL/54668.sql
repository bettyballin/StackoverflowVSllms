SELECT t1.CallGUID, t1.StartedOn, t1.FinishedOn\nFROM ClassMemberCall t1\nJOIN ClassMemberCall t2\nON t1.InstanceGUID = t2.InstanceGUID\nAND t1.StartedOn >= t2.StartedOn\nAND t1.FinishedOn <= t2.FinishedOn\nWHERE t2.CallGUID = '1F45C171-910B-4F17-9286-3D8CDEB7A0C4';