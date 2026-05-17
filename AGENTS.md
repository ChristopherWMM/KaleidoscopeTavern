# AGENTS.md

## Language policy

- 默认使用简体中文回答。
- 除非我明确要求英文，否则不要切换英文叙述。
- 代码、命令、报错、API 名称保持原文，不要强行翻译。
- 提问澄清时也使用中文。

## Project shape

- Single-root NeoForge ModDevGradle 2.x Java mod; use `gradlew.bat` from the repo root on Windows.
- Gradle wrapper is pinned to Gradle 9.4.1, and `build.gradle` requires the Java 25 toolchain.
- Mod id/name/version and Minecraft/NeoForge versions live in `gradle.properties`; `neoforge.mods.toml` expands those
  values during `processResources`, so do not hardcode metadata there.
- Main mod entrypoint is `src/main/java/com/github/ysbbbbbb/kaleidoscopetavern/KaleidoscopeTavern.java`; registry owners
  are mostly `src/main/java/com/github/ysbbbbbb/kaleidoscopetavern/init/Mod*.java`.

## Commands

- Compile/package checks: `./gradlew.bat compileJava`, `./gradlew.bat test`, `./gradlew.bat check`,
  `./gradlew.bat build`.
- ModDev run configs: `./gradlew.bat runClient`, `runClient2`, `runServer`, `runGameTestServer`, `runData`.
- Focused tests use standard Gradle filtering: `./gradlew.bat test --tests <pattern>`; `src/test` currently has no repo
  tests.
- There is no separate lint/typecheck task in this checkout; Java compilation is the practical type/API check.

## Generated and runtime files

- `runData` writes generated assets/data to `src/generated/resources/`; `sourceSets.main.resources` includes that
  directory and excludes `.cache/**`.
- `run/client`, `run/client2`, and `run/server` are local game directories and are ignored by git.
- `META-INF/accesstransformer.cfg` is declared from `neoforge.mods.toml`; if moving it, update both ModDevGradle/TOML
  wiring.
- `kaleidoscope_tavern.mixins.json` is registered but currently has empty `mixins` and `client` arrays.

## Current verification state

- `./gradlew.bat tasks --all` succeeds and lists the ModDev tasks above.
- `./gradlew.bat compileJava` currently fails with many NeoForge/Minecraft 26.1 API migration errors, especially datagen
  provider imports/methods, recipe APIs, render layer signatures, block entity interface return types, and
  `MolotovBlockItem` overrides; do not report a green build without re-running it.

## Toolchain gotchas

- This is NeoForge ModDevGradle, not Fabric Loom or ForgeGradle; use `neoForge { runs { ... } }` conventions.
- Parchment mappings are not visibly enabled in `gradle.properties` or `build.gradle`; do not assume Parchment parameter
  names or Javadocs are available.
- The source uses `net.minecraft.resources.Identifier` instead of the older `ResourceLocation` naming, matching the
  current mapped API in this checkout.
