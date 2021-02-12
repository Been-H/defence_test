package frc.team6502.robot

import edu.wpi.first.wpilibj.XboxController
import frc.team6502.robot.subsystems.Drivetrain

/**
 * Initialize devices and subsystems here
 */
object RobotContainer {

    val controller = XboxController(0) //Not sure which port it will be plugged into so I am putting zero for now


    init {
        Drivetrain
    }

}