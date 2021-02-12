package frc.team6502.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.PIDCommand
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.geometry.Rotation2d
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry
import edu.wpi.first.wpilibj2.command.Command
import frc.team6502.robot.Constants
import frc.team6502.robot.commands.DefaultDrive
import java.lang.Compiler.command

enum class DrivetrainMode {
    DISABLED,
    OPEN_LOOP,
}

object Drivetrain : SubsystemBase() {

    val frontRightSpark = Spark(Constants.FRONT_RIGHT_SPARK_PORT)
    val backRightSpark = Spark(Constants.BACK_RIGHT_SPARK_PORT)
    val frontLeftSpark = Spark(Constants.FRONT_LEFT_SPARK_PORT)
    val backLeftSpark = Spark(Constants.BACK_LEFT_SPARK_PORT)

    val motorLeft = SpeedControllerGroup(frontLeftSpark, backLeftSpark)
    val motorRight = SpeedControllerGroup(frontRightSpark, backRightSpark)

    val differentialDrive = DifferentialDrive(motorLeft, motorRight)

    // Something about DefaultDrive down here that uses PID controllers or something but it like leads to another file or something it never ends
    fun initDefaultCommand() {
        defaultCommand = DefaultDrive()
    }

}