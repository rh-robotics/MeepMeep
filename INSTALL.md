# Step-by-Step Installation Guide (Android Studio)

1.  In Android Studio, click on the "FtcRobotController" Module, then right-click on the FtcRobotController folder and click `New > Module`
    <img width="903" alt="Step-1" src="https://github.com/user-attachments/assets/8c53e58a-d7e7-464c-bf6a-519321db22fd">

2.  On the left part of this window, select "Java or Kotlin Library"
    <img width="1034" alt="Step-2" src="https://github.com/user-attachments/assets/f61f1a2b-9105-4df3-ba99-c73ae504da5b">

3.  From here, remove the `:ftcrobotcontroller:lib` in the "Library Name" section, and rename it to `MeepMeepTesting`. You may use whatever name you wish but the rest of the instructions will assume you have chosen the name `MeepMeepTesting`. Ensure that you also change the "class name" section to match
    <img width="1034" alt="Step-3" src="https://github.com/user-attachments/assets/606ea997-5a48-4ab0-9f76-8035a1400086">

4.  Hit "Finish" at the bottom right of the Module Create window
    <img width="1034" alt="Step-4" src="https://github.com/user-attachments/assets/54d77ba9-f143-4031-9e80-642b538be358">

5.  Open up the `build.gradle` file for the MeepMeepTesting module (or whatever you chose to name it prior). In the `java` section of this file, make sure all uses of `JavaVersion`s are set to `JavaVersion.VERSION_17`
    <img width="508" alt="Step-5" src="https://github.com/user-attachments/assets/4857d3f0-1e5b-4bc5-bec8-158cb2b49ecf">

6.  At the bottom of the file add the following gradle snippet:

```
repositories {
    maven { url = 'https://jitpack.io' }
    maven { url = 'https://maven.brott.dev/' }
}

dependencies {
    implementation 'com.github.rh-robotics:MeepMeep:v1.1.0'
}
```

7.  When android studio prompts you to make a gradle sync, click "Sync Now"
    <img width="965" alt="Step-7" src="https://github.com/user-attachments/assets/9453647d-1f33-44f3-9072-a329ddded062">

8.  Paste the following sample into your main class for the `MeepMeepTesting` module. Feel free to change this later

```java
package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
```

9. Create a run configuration for Android Studio.

   1. First, click on the drop down menu on the top bar of Android Studio, where it says "TeamCode" with a little Android logo next to it
      <img width="416" alt="Step-9 1" src="https://github.com/user-attachments/assets/d8b8b370-0b3c-466d-b727-821e36b4636e">

   2. Click `Edit Configurations`

      <img width="373" alt="Step-9 2" src="https://github.com/user-attachments/assets/51f3a279-3bd6-4060-bfa7-4bc9d1313a10">

   3. Click on the "+" symbol in the top left of the window
      <img width="1073" alt="Step-9 3" src="https://github.com/user-attachments/assets/8725ff76-2dbc-43c3-a9f0-43fd19ccb1ce">

   4. Click `Application`
      <img width="963" alt="Step-9 4" src="https://github.com/user-attachments/assets/324e1050-16e2-4551-ae47-5cb861d6c731">

   5. Change the name to your liking (eg. "MeepMeep")
      <img width="1073" alt="Step-9 5" src="https://github.com/user-attachments/assets/7739ac4a-4ee9-4c63-86d0-233b50409d0a">

   6. Where it says "cp <no module>" click it to open the dropdown, and then select FtcRobotController.MeepMeepTesting.main
      <img width="1073" alt="Step-9 6" src="https://github.com/user-attachments/assets/318ba0e9-a09e-465d-99d7-1cef2a103ed3">

   7. Where it says "Main Class", click the little "file" icon to the right of the text and then select the name of the main class for your MeepMeepTesting module
      <img width="1073" alt="Step-9 7" src="https://github.com/user-attachments/assets/edde99ca-7f2e-47cb-b09e-8859c03ba1dd">

   8. From here, in the bottom right of the window, press "Apply" then "Ok"
      <img width="1073" alt="Step-9 8" src="https://github.com/user-attachments/assets/8ec43003-c50b-4dda-84a3-c6aa66d23182">

   9. It will now automatically switch to that Run/Debug Configuration profile

10. If at any point you would like to build code onto your Control Hub or Phone, then click the Run/Debug configuration profile at the top to open the dropdown menu and select TeamCode. Perform the same steps to switch back to "MeepMeep"
