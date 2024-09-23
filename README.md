# MeepMeep

![JitPack](https://img.shields.io/jitpack/version/com.github.rh-robotics/MeepMeep?style=for-the-badge&logo=jitpack)
![Instagram Badge](https://img.shields.io/badge/%40rh--iron--lions-yellow?style=for-the-badge&logo=instagram&logoColor=%23edbe28&label=Instagram&labelColor=%23676767&color=%23edbe28&link=https%3A%2F%2Finstagram.com%2Frh-iron-lions)
![Email Badge](https://img.shields.io/badge/ironlions19922%40gmail.com-yellow?style=for-the-badge&logo=gmail&logoColor=%23edbe28&label=Email&labelColor=%23676767&color=%23edbe28&link=mailto%3Aironlions19922%40gmail.com)

**Contact Us At:**

- @rh-iron-ions On Instagram
- ironlions19922@gmail.com

---

## Table of Contents

- [Installation (Android Studio)](#installation-android-studio)
- [Full Documentation (Kotlin Docs)](#full-documentation-kotlin-docs)
- [Misc Info](#extra-tips)
    - [Poor Performance Fix](#poor-performance-fix)
    - [Default Bot Constraints](#default-bot-constraints)

## Installation (Android Studio)

1. In Android Studio, click on the "FtcRobotController" Module, then right click on the
   FtcRobotController folder and click `New > Module`
   <img src="/images/readme/installationStep1.png" width="751" height="287"/>
2. On the left part of this window, select "Java or Kotlin Library"
   <img src="/images/readme/installationStep2.png" width="544" height="382"/>

3. From here, remove the `:ftcrobotcontroller:lib` in the "Library Name" section, and rename it
   to `MeepMeepTesting`. You may use whatever name you wish but the rest of the instructions will
   assume you have chosen the name `MeepMeepTesting`. Ensure that you also change the "class name"
   section to match.

4. Hit "Finish" at the bottom right of the Module Create window.

5. Open up the `build.gradle` file for the MeepMeepTesting module (or whatever you chose to name it
   prior). In this file, change all instances `JavaVersion.VERSION_1_7` to `JavaVersion.VERSION_1_8`
   <img src="/images/readme/installationStep5.png" width="566" height="274"/>

6. At the bottom of the file add the following gradle snippet:

    ```
    repositories {
        maven { url = 'https://jitpack.io' }
        maven { url = 'https://maven.brott.dev/' }
    }
    
    dependencies {
        implementation 'com.github.NoahBres:MeepMeep:2.0.3'
    }
    ```

7. When android studio prompts you to make a gradle sync, click "Sync Now".
   <img src="/images/readme/installationStep7.png" width="644" height="20"/>

8. Create a class for your MeepMeepTesting java module if it does not yet exist. Paste the following
   sample in it. Feel free to change this later.

## Full Documentation (Kotlin Docs)

TODO!

## Extra Tips

### Custom Background

Before the `meepmeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)`, add the
following
lines of code and update the setBackground() command:

```java
  Image img = null;
  try{ img =ImageIO.read(new File("<PATH TO IMAGE>")); }
  catch(IOException e) {}
  
  meepMeep.setBackground(img)
```

where <PATH TO IMAGE> is your path to the image you want to use for example:

- On MacOs: `/Users/<username>/Documents/field.png`
- On Windows: `C:\Users\<username>\Documents\field.png`

### Pulling Specific JitPack Commits

MeepMeep is hosted on JitPack. This allows the user to pull dependencies from any Git commit. Change
the dependency version in build.gradle to do so.

- Pull from a specific tagged version (same as install instructions)
    - `implementation 'com.github.NoahBres:MeepMeep:2.0.3'`
    - `2.0.3` can be replaced with whatever version specified on
      the [GitHub releases page](https://github.com/NoahBres/MeepMeep/releases)
- Pull from whatever the latest commit on the master branch is
    - `implementation 'com.github.NoahBres:MeepMeep:-SNAPSHOT'`
- Pull from a specific commit
    - `implementation 'com.github.NoahBres:MeepMeep:<commit version ID>'`
    - `<commit ID>` is replaced with ID of commit. For example "79d123f0c1"
    - This is not the full commit hash. It is the first 10 characters of the comit hash

### Poor Performance Fix

On some systems, hardware acceleration may not be enabled by default. To enable hardware
acceleration add this before initializing your MeepMeep instance with the following snippet:
`System.setProperty("sun.java2d.opengl", "true");`

### Default Bot Constraints

- **Max Velocity:** 30in/s
- **Max Acceleration:** 30in/s/s
- **Max Angular Velocity:** 60deg/s
- **Max Angular Acceleration:** 60deg/s/s
- **Track Width**: 15in
- **Bot Width:** 18in
- **Bot Height:** 18in
- **Start Position:** (x: 0in, y: 0in, heading: 0rad)
- **Color Scheme:** Inherited from MeepMeep.colorManager unless overridden
- Drive Train Type: Mecanum
