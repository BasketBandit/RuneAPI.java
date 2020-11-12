# RuneAPI.java
Simple open source Java wrapper for the OSRS portion of the [RuneScape](https://oldschool.runescape.com/) API.

## Class Data

### Methods

```java
 .getStats(String username);
```

## Usage

### Get

**#1** - Loop through all skills and print the data.
```java
Map<String, Skill> skills = RuneAPI.getStats(username);

for(Skill skill: skills.values()) {
    System.out.printf("%s: #%,d - %,d - %,dxp \n", skill.getName(), skill.getRank(), skill.getLevel(), skill.getExperience());
}
```

**#2** - Find specific skill and print the data.
```java
Map<String, Skill> skills = RuneAPI.getStats(username);
Skill overall = skills.get(Skills.OVERALL);

System.out.printf("%s: #%,d - %,d - %,dxp \n", overall.getName(), overall.getRank(), overall.getLevel(), overall.getExperience());
```

### Interface
Provided is an interface class which contains both a ```List<String>``` of all skill names accessed via ```Skills.asList```, 
and each individual skill ```String``` accessed via the skills name, e.g ```Skills.COOKING```. 
This allows you to access a skill map without fear of mistyping the name of a skill. An example using this interface is given above.

## Download

[![](https://jitpack.io/v/BasketBandit/RuneAPI.java.svg)](https://jitpack.io/#BasketBandit/RuneAPI.java)
 
Replace `VERSION` with the JitPack version number you can see above.
 
#### Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

```gradle
dependencies {
    implementation 'com.github.BasketBandit:RuneAPI.java:VERSION'
}
```
 
#### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```  

```xml
<dependency>
    <groupId>com.github.BasketBandit</groupId>
    <artifactId>RuneAPI.java</artifactId>
    <version>VERSION</version>
</dependency>
```