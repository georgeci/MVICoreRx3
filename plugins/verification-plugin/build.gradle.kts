plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    alias(libs.plugins.detekt)
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.detekt)
}

tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile::class.java).configureEach {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.name
}

detekt {
    buildUponDefaultConfig = true
    config.from(file("../../detekt.yml"))
}

gradlePlugin {
    plugins {
        create("mvi-core-collect-sarif") {
            id = "mvi-core-collect-sarif"
            implementationClass = "CollectSarifPlugin"
        }
        create("mvi-core-lint") {
            id = "mvi-core-lint"
            implementationClass = "LintPlugin"
        }
        create("mvi-core-detekt") {
            id = "mvi-core-detekt"
            implementationClass = "DetektPlugin"
        }
    }
}
