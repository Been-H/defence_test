package frc.team6502.robot.commands

import com.ctre.phoenix.sensors.PigeonIMU
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.controller.PIDController
import edu.wpi.first.wpilibj2.command.PIDCommand
import frc.team6502.robot.subsystems.Drivetrain

class DefaultDrive : PIDCommand(0.01, 0.0, 0.01) {

    private val correctionLimit = 0.33
    val kIMU = PigeonIMU(5) //not sure what the device Id is

    private var yawCorrection = 0.0
    private var yawCorrecting = false
    private val yawTimer = Timer()

    private var visionCorrection = 0.0

    private var quickStopAccumulator = 0.0

    // FRONT TOGGLE
    private var frontIsFront = true


    init {}
        //tried requires Drivetrain class but requires didn't exist

    override fun initialize() {
        println("STARTING DRIVETRAIN") //why do we do this?
        yawTimer.start()
        yawCorrection = 0.0
        yawCorrecting = true

    }

}