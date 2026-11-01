plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.google.gms) apply false
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

if (file("google-services.json").exists()) {
    apply(plugin = "com.google.gms.google-services")
}

android {
    namespace = "com.illusion.checkfirm"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.illusion.checkfirm"
        minSdk = 28
        targetSdk = 36
        versionCode = 58
        versionName = "11.2.1"
    }

    
        buildTypes {
        debug {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    androidResources {
        generateLocaleConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    packaging {
        resources {
            pickFirsts += arrayOf(
                "META-INF/LICENSE.md",
                "META-INF/NOTICE.md"
            )
        }
    }
}

kotlin {
    jvmToolchain(jdkVersion = 21)
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    implementation(project(":oneui"))
    implementation(libs.appcompat)
    implementation(libs.ksoup)
    implementation(libs.recyclerview)
    implementation(libs.splashscreen)

    implementation(libs.bundles.angus)
    implementation(libs.bundles.bases)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.datas)
    implementation(libs.bundles.designs)
    implementation(libs.bundles.firebases)
    implementation(libs.bundles.ktors)
    implementation(libs.bundles.lifecycles)

    ksp(libs.room.compiler)
}
