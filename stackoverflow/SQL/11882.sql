Update Courses C  \n   SET Instructor_ID = \n          (Select User_ID from Course_Roster\n           Where CourseID = C.Course_ID)