package frc.team6502.robot.subsystems
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.PIDCommand
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj2.command.Command
import java.lang.Compiler.command

enum class DrivetrainMode {
    DISABLED,
    OPEN_LOOP,
}

object Drivetrain : SubsystemBase() {

    val rightSpark1 = Spark(0)
    val rightSpark2 = Spark(1)
    val leftSpark1 = Spark(2)
    val leftSpark2 = Spark(3)

    fun set(left : Double, right : Double, mode : DrivetrainMode) {
        when(mode) {
            DrivetrainMode.DISABLED -> setPercentages(0.0, 0.0)
            DrivetrainMode.OPEN_LOOP -> setPercentages(left, right)
        }
    }

    fun setPercentages(left : Double, right : Double) {
        leftSpark1.set(left)
        leftSpark2.set(left)
        rightSpark1.set(right)
        rightSpark2.set(right)
    }

    fun getPercentages() {
        val right1 = rightSpark1.get()
        val right2 = rightSpark2.get()
        val left1 = leftSpark1.get()
        val left2 = leftSpark2.get()

        val percentages = arrayOf<Double>()
    }

    // Something about DefaultDrive down here that uses PID controllers or something but it like leads to another file or something it never ends
    fun initDefaultCommand() {}

}