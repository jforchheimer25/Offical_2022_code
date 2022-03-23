// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class StopShootCommand extends CommandBase {
  Shooter m_Shooter;
  boolean bool = false;
  public StopShootCommand(Shooter _Shooter) {
    m_Shooter = _Shooter;
    addRequirements(m_Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Shooter.shooterOff();
    bool = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    bool = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return bool;
  }
}
