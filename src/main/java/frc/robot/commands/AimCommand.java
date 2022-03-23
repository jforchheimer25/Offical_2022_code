// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AimCommand extends PIDCommand {
  DriveTrain m_DriveTrain;
  Shooter m_Shooter;
  public AimCommand(DriveTrain _DriveTrain, Shooter _Shooter) {
    super(
        // The controller that the command will use
        new PIDController(0, 0, 0),
  
        _Shooter::getX,
        0,
        output -> {

          _DriveTrain.drive(() -> 0, () -> 0, () -> output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().enableContinuousInput(-29.8, 29.8);
    getController().setTolerance(1, 0);
    m_Shooter = _Shooter;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(m_Shooter.getX()) <= 1) {
      return true;
    } else {
      return false;
    }
  }
}
