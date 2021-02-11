package frc.team6502.robot.subsystems
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.PIDCommand
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.geometry.Rotation2d
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry
import edu.wpi.first.wpilibj2.command.Command
import frc.team6502.robot.Constants
import java.lang.Compiler.command

enum class DrivetrainMode {
    DISABLED,
    OPEN_LOOP,
}

object Drivetrain : SubsystemBase() {

    val differentialDrive = DifferentialDrive()

    val frontRightSpark = Spark(Constants.FRONT_RIGHT_SPARK_PORT)
    val backRightSpark = Spark(Constants.BACK_RIGHT_SPARK_PORT)
    val frontLeftSpark = Spark(Constants.FRONT_LEFT_SPARK_PORT)
    val backLeftSpark = Spark(Constants.BACK_LEFT_SPARK_PORT)

    fun set(left : Double, right : Double, mode : DrivetrainMode) {
        when(mode) {
            DrivetrainMode.DISABLED -> setPercentages(0.0, 0.0)
            DrivetrainMode.OPEN_LOOP -> setPercentages(left, right)
        }
    }

    fun setPercentages(left : Double, right : Double) {
        frontLeftSpark.set(left)
        backLeftSpark.set(left)
        frontRightSpark.set(right)
        backRightSpark.set(right)
    }

    fun getPercentages() : Array<Double> {
        val right1 : Double = frontRightSpark.get()
        val left1 : Double = frontLeftSpark.get()
        val percentages = arrayOf<Double>(right1, left1)
        return percentages
    }

    // Something about DefaultDrive down here that uses PID controllers or something but it like leads to another file or something it never ends
    fun initDefaultCommand() {}

}