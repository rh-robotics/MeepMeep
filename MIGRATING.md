# Migrating from [NoahBres/MeepMeep](https://github.com/NoahBres/MeepMeep)
1. Locate and open the build.gradle file for the MeepMeep module
   <img width="508" alt="Step-5" src="https://github.com/user-attachments/assets/4857d3f0-1e5b-4bc5-bec8-158cb2b49ecf">

2. Replace the `dependencies` section with the following:

```
dependencies {
   implementation 'com.github.rh-robotics:MeepMeep:v1.1.0'
}
```

3. When prompted by Android Studio, click on `Sync Now` to update the project with the new dependency
   <img width="965" alt="Step-7" src="https://github.com/user-attachments/assets/9453647d-1f33-44f3-9072-a329ddded062">

4. In your main MeepMeep class, replace any import statements that reference `com.noahbres.meepmeep` with `org.rowlandhall.meepmeep`

5. You have now successfully migrated from NoahBres/MeepMeep to rh-robotics/MeepMeep! 🎉
