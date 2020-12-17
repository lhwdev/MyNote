import org.jetbrains.compose.compose

plugins {
	id("com.android.library")
	kotlin("multiplatform")
	id("org.jetbrains.compose")
}

kotlin {
	android()
	jvm("desktop")
	
	sourceSets {
		all {
			languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
			languageSettings.useExperimentalAnnotation("kotlin.io.path.ExperimentalPathApi")
		}
		named("commonMain") {
			dependencies {
				api(compose.runtime)
				api(compose.foundation)
				api(compose.material)
				
				implementation(project(":repository"))
			}
		}
		
		named("desktopMain") {
			dependencies {
				implementation(compose.desktop.currentOs)
			}
		}
		named("androidMain") {
			dependencies {
				implementation("androidx.appcompat:appcompat:1.2.0")
				implementation("androidx.core:core-ktx:1.3.2")
			}
		}
	}
}

dependencies {
//	kotlinCompilerPluginClasspath(files("D:\\LHW\\asm\\app\\new\\com.asmx.core\\dump-ir\\compiler-plugin\\build\\libs\\compiler-plugin.jar"))
}

android {
	compileSdkVersion(30)
	
	defaultConfig {
		minSdkVersion(21)
		targetSdkVersion(30)
		versionCode = 1
		versionName = "1.0"
	}
	
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	
	sourceSets {
		named("main") {
			manifest.srcFile("src/androidMain/AndroidManifest.xml")
			res.srcDirs("src/androidMain/res")
		}
	}
}
