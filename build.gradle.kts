buildscript {
	val composeVersion = System.getenv("COMPOSE_TEMPLATE_COMPOSE_VERSION") ?: "0.1.0-m1-build62"
	val kotlinVersion = "1.4.10"
	
	
	repositories {
		// TODO: remove after new build is published
		mavenLocal()
		google()
		jcenter()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
	
	dependencies {
		classpath("org.jetbrains.compose:compose-gradle-plugin:$composeVersion")
		classpath("com.android.tools.build:gradle:4.0.1")
		classpath(kotlin("gradle-plugin", version = kotlinVersion))
		classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
	}
}

allprojects {
	repositories {
		google()
		jcenter()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
}
