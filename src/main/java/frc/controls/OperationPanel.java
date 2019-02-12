package frc.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperationPanel {
	Joystick joystick;

	public OperationPanel(int port) {
		joystick = new Joystick(port);
	}

	public boolean getButtonValue(ButtonCode button) {
		return joystick.getRawButton(getButtonNumber(button));
	}

	public JoystickButton getButton(ButtonCode button) {
		return new JoystickButton(joystick, getButtonNumber(button));
	}

	public int getButtonNumber(ButtonCode button) {
		int buttonNumber;

		switch (button) {
		case ELEVATOROVERRIDEDOWN:
			buttonNumber = 1;
			break;
		case ELEVATOROVERRIDEUP:
			buttonNumber = 2;
			break;
		case ARMOVERRIDERETRACT:
			buttonNumber = 3;
			break;
		case ARMOVERRIDEEXTEND:
			buttonNumber = 4;
			break;
		case CARGOSPITOVERRIDE:
			buttonNumber = 5;
			break;
		case CARGOSUCKOVERRIDE:
			buttonNumber = 6;
			break;
		case BEAKCAPTUREOVERRIDE:
			buttonNumber = 7;
			break;
		case BEAKRELEASEOVERRIDE:
			buttonNumber = 8;
			break;
		case CARGOORHATCHPANEL:
			buttonNumber = 9;
			break;
		case SETLOCATIONCARGOSHIP:
			buttonNumber = 10;
			break;
		case SETLOCATIONROCKET:
			buttonNumber = 11;
			break;
		case ROCKETHEIGHTHIGH:
			buttonNumber = 12;
			break;
		default:
			throw new IllegalArgumentException("Invalid Button Code");
		}

		return buttonNumber;
	}
}
