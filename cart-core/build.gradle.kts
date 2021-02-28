plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

kotlin {
    multiplatformLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx("serialization-json", vers.kotlinx.serialization))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test-core", vers.asoft.test))
                implementation(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.cart,
    description = "A platform agnostic library for managing carts"
)