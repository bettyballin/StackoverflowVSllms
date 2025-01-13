SELECT \n    u.userid AS userId, \n    u.username AS username, \n    ut.description AS userTypeDescription, \n    i.imageid AS imageId, \n    i.location AS imageLocation, \n    it.description AS imageTypeDescription\nFROM user u\nINNER JOIN type ut ON ut.typeid = u.usertypeid\nINNER JOIN image i ON i.imageid = u.imageid\nINNER JOIN type it ON it.typeid = i.imagetypeid\nWHERE u.userid = @userid;