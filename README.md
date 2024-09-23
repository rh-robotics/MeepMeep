# MeepMeep

![JitPack](https://img.shields.io/jitpack/version/com.github.rh-robotics/MeepMeep?style=for-the-badge&logo=jitpack)

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
TODO!

## Full Documentation (Kotlin Docs)
TODO!

## Extra Tips

### Custom Background

Before the `meepmeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)`, add the following
lines of code and update the setBackground() command:

```java
  Image img = null;
  try{ img = ImageIO.read(new File("<PATH TO IMAGE>")); }
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