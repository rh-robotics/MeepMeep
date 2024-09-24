# MeepMeep

![JitPack](https://img.shields.io/jitpack/version/com.github.rh-robotics/MeepMeep?style=for-the-badge&logo=jitpack&logoColor=%23edbe28&logoSize=%23edbe28&labelColor=%23676767&color=%23edbe28)
![Instagram Badge](https://img.shields.io/badge/%40rh--iron--lions-yellow?style=for-the-badge&logo=instagram&logoColor=%23edbe28&label=Instagram&labelColor=%23676767&color=%23edbe28&link=https%3A%2F%2Finstagram.com%2Frh-iron-lions)
![Email Badge](https://img.shields.io/badge/ironlions19922%40gmail.com-yellow?style=for-the-badge&logo=gmail&logoColor=%23edbe28&label=Email&labelColor=%23676767&color=%23edbe28&link=mailto%3Aironlions19922%40gmail.com)

---

## Table of Contents

- [Installation](#installation)
- [Full Documentation (Kotlin Docs)](#full-documentation-kotlin-docs)
- [Misc Info](#extra-tips)
  - [Poor Performance Fix](#poor-performance-fix)
  - [Default Bot Constraints](#default-bot-constraints)

## Installation

See [INSTALL.md](https://github.com/rh-robotics/MeepMeep/blob/master/INSTALL.md)

## Full Documentation (Kotlin Docs)

See the full Kotlin documentation on [GitHub Sites](https://rh-robotics.github.io/MeepMeep)

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
  - `implementation 'com.github.rh-robotics:MeepMeep:1.0.0'`
  - `1.0.0` can be replaced with whatever version specified on
    the [GitHub releases page](https://github.com/NoahBres/MeepMeep/releases)
- Pull from whatever the latest commit on the master branch is
  - `implementation 'com.github.rh-robotics:MeepMeep:-SNAPSHOT'`
- Pull from a specific commit
  - `implementation 'com.github.rh-robotics:MeepMeep:<commit version ID>'`
  - `<commit ID>` is replaced with the ID of the commit. For example "79d123f0c1"
  - This is not the full commit hash, rather, the first 10 characters of the commit hash

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
