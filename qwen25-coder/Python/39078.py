# Simple example to turn the NXT brick motors on and off\n  import pynxt\n  b = pynxt.locator.find_one_brick()\n  motorA = pynxt.motor.Motor(pynxt.locator.PORT_A)\n  motorA.turn(100, 360)  # Turn a full circle at 100 power.