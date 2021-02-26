plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

kotlin {
    multiplatformLib()
    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test-core", vers.asoft.test))
                implementation(asoft("expect-core",vers.asoft.expect))
            }
        }
    }
}