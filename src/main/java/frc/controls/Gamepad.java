package frc.controls;

import frc.robot.Calibrations;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Gamepad {
	Joystick joystick;

	public Gamepad(int port) {
		joystick = new Joystick(port);
	}

	public boolean getButtonValue(ButtonCode button) {
		return joystick.getRawButton(getButtonNumber(button));
	}

	public JoystickButton getButton(ButtonCode button) {
		return new JoystickButton(joystick, getButtonNumber(button));
	}

	public boolean getAxisIsPressed(AxisCode axis) {
		boolean isPressed = false;
		double axisValue = this.getAxis(axis);

		if (axisValue >= Calibrations.AXIS_IS_PRESSED_VALUE) {
			isPressed = true;
		}

		return isPressed;
	}

	public double getAxis(AxisCode axis) {
		double axisValue;

		switch (axis) {
		case LEFTSTICKX:
			axisValue = joystick.getRawAxis(0);
			break;
		case LEFTSTICKY:
			axisValue = joystick.getRawAxis(1);
			break;
		case LEFTTRIGGER:
			axisValue = joystick.getRawAxis(2);
			break;
		case RIGHTTRIGGER:
			axisValue = joystick.getRawAxis(3);
			break;
		case RIGHTSTICKX:
			axisValue = joystick.getRawAxis(4);
			break;
		case RIGHTSTICKY:
			axisValue = joystick.getRawAxis(5);
			break;
		default:
			axisValue = 0;
			break;
		}
		return axisValue;
	}

	public int getButtonNumber(ButtonCode button) {
		int buttonNumber;

		switch (button) {
		case A:
			buttonNumber = 1;
			break;
		case B:
			buttonNumber = 2;
			break;
		case X:
			buttonNumber = 3;
			break;
		case Y:
			buttonNumber = 4;
			break;
		case LEFTBUMPER:
			buttonNumber = 5;
			break;
		case RIGHTBUMPER:
			buttonNumber = 6;
			break;
		case BACK:
			buttonNumber = 7;
			break;
		case START:
			buttonNumber = 8;
			break;
		case LEFTSTICK:
			buttonNumber = 9;
			break;
		case RIGHTSTICK:
			buttonNumber = 10;
			break;
		default:
			throw new IllegalArgumentException("Invalid Button Code");
		}

		return buttonNumber;
	}
}
