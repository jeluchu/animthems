
[![Discord Server](https://img.shields.io/discord/460491088004907029.svg?style=flat&logo=discord)](https://discord.gg/2DZHfxv9XN)  [![](https://jitpack.io/v/jeluchu/animthems.svg)](https://jitpack.io/#jeluchu/animthems)

Wrapper for [Anime Themes](https://animethemes.moe/) build using Kotlin + Kotlin DSL + Coroutines power 🚀

# Installation
with Gradle
```groovy  
repositories {   
	maven { url 'https://jitpack.io' }  
}  
  
dependencies {  
	implementation("com.github.jeluchu:animthems:1.0.0")
}  
```  
# Example
```kotlin  
fun main() {  
	val anime = runBlocking { Animthems.getAnimes() } 
	println(anime[0].name) // Prints: Shigatsu wa Kimi no Uso
}  
```      

# Available requests (Soon)

# Release
For latest release or to check the changelogs, please check Release tab.

# Contribution
Want to help? I'm very open to contributors so just do it or contact me if you have any question (Discord: jeluchu)