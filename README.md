# RuneAPI.java
Simple open source Java wrapper for the OSRS portion of the [RuneScape](https://oldschool.runescape.com/) API.

## Class Data

### Methods

```java
 .getStats(String username);
```

## Usage

### Get

**Stats** - Retrieve the stats stored about the provided player.

**#1** - Loop all skills and print their data.
```java
Map<Type, Skill> stats = RuneAPI.getStats(username);

for(Skill skill: stats.values()) {
    System.out.printf("%s: #%,d - %,d - %,dxp \n", skill.getName(), skill.getRank(), skill.getLevel(), skill.getExperience());
}
```

**#2** - Find specific skill and print its data.
```java
Map<Type, Skill> stats = RuneAPI.getStats(username);
Skill overall = stats.get(Type.OVERALL);

System.out.printf("%s: #%,d - %,d - %,dxp \n", overall.getName(), overall.getRank(), overall.getLevel(), overall.getExperience());
```

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