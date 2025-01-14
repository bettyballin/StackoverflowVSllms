Public Shared Function Save(appointment As MyLinq.Appointment, db As MyEntities) As Boolean\n    If appointment.id = 0 Then\n        ' New appointment, add and save\n        db.AddToAppointments(appointment)\n    Else\n        ' Existing appointment, attach with EntityState set to Modified\n        Dim existingAppointment As New MyLinq.Appointment() With {.id = appointment.id}\n        db.Attach(existingAppointment) ' Attach a shell of the entity\n        db.ObjectStateManager.ChangeObjectState(existingAppointment, System.Data.EntityEntityState.Unchanged)\n        db.ApplyCurrentValues("Appointments", appointment) ' Apply actual changes from appointment\n    End If\n\n    Return db.SaveChanges() > 0\nEnd Functio