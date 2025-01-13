var results = db.ratesSchedule\n    .Join(db.userdetails,\n          rs => rs.sid,\n          ud => ud.sid,\n          (rs, ud) => new { rs, ud })\n    .Where(x => x.rs.tabletype == "d");