package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController;
import frc.lib.util.PIDConstants;
import frc.lib.util.SVAConstants;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {

  public static enum ControlModes {
    Slew,
    Raw,
  }

  public static enum RobotModes {
    Competition,
    Testing
  }

  public static final RobotModes robotMode = RobotModes.Testing;

  public static final class Vision {
    public static final String cameraName = "gloworm";
  }

  public static final class Operators {
    public static final int driver = 0;
    public static final ControlModes driverMode = ControlModes.Raw;
  }

  public static final class Swerve {

    /* Drive Controls */
    public static final double stickDeadband = 0.1;
    public static final int translationAxis = XboxController.Axis.kRightY.value;
    public static final int strafeAxis = XboxController.Axis.kRightX.value;
    public static final int rotationAxis = XboxController.Axis.kLeftX.value;
    public static final int zeroGyro = XboxController.Button.kStart.value;
    public static final int robotCentric = XboxController.Button.kLeftBumper.value;

    /* Gyro */
    public static final int pigeonID = 21;
    public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-
    public static final String pigeonCanBUS = "canivore3161";

    /* Drivetrain Constants */
    public static final double trackWidth = Units.inchesToMeters(23.0);
    public static final double wheelBase = Units.inchesToMeters(23.0);
    public static final double wheelDiameter = Units.inchesToMeters(4.0);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double openLoopRamp = 0.25;
    public static final double closedLoopRamp = 0.0;

    public static final double driveGearRatio = (6.75 / 1.0); // 6.75:1
    public static final double angleGearRatio = 150.0 / 7.0; // 150/7:1

    /* Custom PID Controllers */
    public static final PIDConstants robotRotationPID = new PIDConstants(0.1, 0, 0.00005);
    public static final PIDConstants targetRotationPID = new PIDConstants(6, 0, 0.05);
    public static final PIDConstants targetTranslationPID = new PIDConstants(2, 0, 0.005);

    public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
        new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Swerve Compensation */
    public static final double voltageComp = 12.0;

    /* Swerve Current Limiting */
    public static final int angleContinuousCurrentLimit = 20;
    public static final int driveContinuousCurrentLimit = 40;

    /* Drive Motor Conversion Factors */
    public static final double driveConversionPositionFactor = (wheelDiameter * Math.PI) / driveGearRatio;
    public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60.0;
    public static final double angleConversionFactor = 360.0 / angleGearRatio;

    /* Swerve Profiling Values */
    public static final double maxSpeed = 4.5; // meters per second
    public static final double maxAngularVelocity = 11.5;
    public static final double translationChangeLimit = 20.0;
    public static final double strafeChangeLimit = 20.0;
    public static final double rotationChangeLimit = 20.0;

    /* Neutral Modes */
    public static final IdleMode angleNeutralMode = IdleMode.kBrake;
    public static final IdleMode driveNeutralMode = IdleMode.kBrake;

    /* Motor Inverts */
    public static final boolean driveInvert = true;
    public static final boolean angleInvert = true;

    /* Angle Encoder Invert */
    public static final boolean canCoderInvert = false;

    /* Module Specific Constants */
    public static final String[] moduleNames = { "Front Left", "Front Right", "Back Left", "Back Right" }; // module #0,
                                                                                                           // #1, #2, #3

    /* Front Left Module - Module 0 */
    public static final class Mod0 {
      public static final int driveMotorID = 2;
      public static final int angleMotorID = 1;
      public static final int canCoderID = 23;
      public static final String cancoderCANBUS = "canivore3161"; // change to "rio" if it's on rio
      public static final double angleOffset = 146.0;
      public static final PIDConstants anglePID = new PIDConstants(0.02, 0.0, 0.005);
      public static final PIDConstants drivePID = new PIDConstants(0.1, 0.0, 0.000);
      public static final SVAConstants driveSVA = new SVAConstants(0.13522, 2.6797, 0.17176);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, cancoderCANBUS, angleOffset, anglePID, drivePID, driveSVA);
    }

    /* Front Right Module - Module 1 */
    public static final class Mod1 {
      public static final int driveMotorID = 4;
      public static final int angleMotorID = 3;
      public static final int canCoderID = 24;
      public static final String cancoderCANBUS = "canivore3161";
      public static final double angleOffset = 324.0;
      public static final PIDConstants anglePID = new PIDConstants(0.02, 0.0, 0.005);
      public static final PIDConstants drivePID = new PIDConstants(0.1, 0.0, 0.000);
      public static final SVAConstants driveSVA = new SVAConstants(0.13522, 2.6797, 0.17176);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, cancoderCANBUS, angleOffset, anglePID, drivePID, driveSVA);
    }

    /* Back Left Module - Module 2 */
    public static final class Mod2 {
      public static final int driveMotorID = 8;
      public static final int angleMotorID = 7;
      public static final int canCoderID = 22;
      public static final String cancoderCANBUS = "canivore3161";
      public static final double angleOffset = 290.0;
      public static final PIDConstants anglePID = new PIDConstants(0.02, 0.0, 0.005);
      public static final PIDConstants drivePID = new PIDConstants(0.1, 0.0, 0.000);
      public static final SVAConstants driveSVA = new SVAConstants(0.13522, 2.6797, 0.17176);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, cancoderCANBUS, angleOffset, anglePID, drivePID, driveSVA);
    }

    /* Back Right Module - Module 3 */
    public static final class Mod3 {
      public static final int driveMotorID = 6;
      public static final int angleMotorID = 5;
      public static final int canCoderID = 25;
      public static final String cancoderCANBUS = "canivore3161";
      public static final double angleOffset = 90.0;
      public static final PIDConstants anglePID = new PIDConstants(0.02, 0.0, 0.005);
      public static final PIDConstants drivePID = new PIDConstants(0.1, 0.0, 0.000);
      public static final SVAConstants driveSVA = new SVAConstants(0.13522, 2.6797, 0.17176);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, cancoderCANBUS, angleOffset, anglePID, drivePID, driveSVA);
    }
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 0.5;
    public static final double kMaxAccelerationMetersPerSecondSquared = 0.5;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 0.1;
    public static final double kPYController = 0.1;
    public static final double kPThetaController = 0.1;

    // Constraint for the motion profilied robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }
}
