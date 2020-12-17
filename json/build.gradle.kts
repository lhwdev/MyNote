import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeTargetPreset

plugins {
	kotlin("multiplatform")
	id("kotlinx-serialization")
}

kotlin {
	jvm()
	
	js {
		browser()
		nodejs()
	}
	
	sourceSets {
		all {
			languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
		}
		
		commonMain {
			dependencies {
				implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0")
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")
			}
		}
		
		named("jvmTest") {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}
		
		create("nativeMain") {
			dependsOn(commonMain.get())
		}
	}
	
	presets.withType<AbstractKotlinNativeTargetPreset<*>>().forEach {
		targetFromPreset(it) {
			compilations.getByName("main") {
				defaultSourceSet.dependsOn(sourceSets["nativeMain"])
			}
		}
	}
}