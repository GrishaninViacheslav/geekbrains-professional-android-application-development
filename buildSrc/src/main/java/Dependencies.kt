import org.gradle.api.JavaVersion

object Config {
    const val application_id =
        "io.github.grishaninvyacheslav.geekbrains_professional_android_application_development"
    const val compile_sdk = 30
    const val min_sdk = 23
    const val target_sdk = 30
    const val build_tools_version = "30.0.3"
    val java_version = JavaVersion.VERSION_1_8
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val app = ":app"
    const val domain = ":domain"
    // Features
    const val historyScreen = ":historyScreen"
}

object Versions {
    // Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraint_layout = "2.1.0"

    // Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.5.21"
    const val coroutinesCore = "1.4.3"
    const val coroutinesAndroid = "1.4.3"

    // Dagger
    const val dagger = "2.37"

    // Cicerone
    const val cicerone = "6.6"

    // Retrofit
    const val retrofit = "2.6.0"
    const val converterGson = "2.6.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"
    const val adapter = "2.9.0"

    // Rxjava
    const val rx_java = "2.2.20"
    const val rx_kotlin = "2.4.0"
    const val rx_android = "2.1.1"

    // Koin
    const val koinAndroid = "2.1.6"
    const val koinViewModel = "2.1.6"

    // Coil
    const val coil = "0.11.0"

    // Room
    const val roomKtx = "2.3.0"
    const val runtime = "2.3.0"
    const val roomCompiler = "2.3.0"

    // Glide
    const val glide = "4.11.0"

    // Test
    const val jUnit = "4.+"
    const val runner = "1.2.0"
    const val espressoCore = "3.4.0"
    const val ext = "1.1.3"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Cicerone {
    const val cicerone = "com.github.terrakok:cicerone:${Versions.cicerone}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapter_coroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.adapter}"
}

object RxJava {
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
}

object Koin {
    const val koin_android = "org.koin:koin-android:${Versions.koinAndroid}"
    const val koin_view_model = "org.koin:koin-android-viewmodel:${Versions.koinViewModel}"
}

object Coil {
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object Glide{
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val ext = "androidx.test.ext:junit:${Versions.ext}"
}

