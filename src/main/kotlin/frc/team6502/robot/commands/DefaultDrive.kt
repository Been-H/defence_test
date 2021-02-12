package frc.team6502.robot.commands

import com.ctre.phoenix.sensors.PigeonIMU
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.PIDCommand
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team6502.robot.RobotContainer.controller
import frc.team6502.robot.subsystems.Drivetrain
import frc.team6502.robot.subsystems.Drivetrain.differentialDrive

class DefaultDrive : CommandBase(){

    override fun execute() {
        val throttle = controller.getY()
        val rotation = controller.getX()

        differentialDrive.arcadeDrive(throttle, rotation)
    }

}