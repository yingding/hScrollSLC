# horizontalScroll conflicts on SLC

This repo shows that the `horizontalScroll` modifier doesn't work on the parent composable of `androidx.wear.compose.material.ScalingLazyColumn`,
On the contrary, `horizontalScroll` works on 

Dependencies:
* wear compose 1.1.0
* compose 1.3.2

Android Studio 
```
Android Studio Dolphin | 2021.3.1 Patch 1
Build #AI-213.7172.25.2113.9123335, built on September 30, 2022
Runtime version: 11.0.13+0-b1751.21-8125866 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 12.6.2
GC: G1 Young Generation, G1 Old Generation
Memory: 4096M
Cores: 10
Registry:
    external.system.auto.import.disabled=true
    ide.text.editor.with.preview.show.floating.toolbar=false
    ide.instant.shutdown=false

Non-Bundled Plugins:
    idea.plugin.protoeditor (213.6461.28)
```

Emulator Version: 31.3.14
AVD: Wear OS 3 - Preview ARM 64 v8a System Image API 30, Rev 11

## How to recreate the issue

Please switch the `hasChildSLC` variable between `true` and `false`
in the `onCreate()` of the `MainActivity.kt` 
```
        setContent {
            WearAppTheme {
                // set the hasChildSLC to true to trigger IllegalArgumentException
                val hasChildSLC = true
                horizontalScollSLC(hasChildSLC = hasChildSLC)
            }
        }
```

to reproduce the `IllegalArgumentException`:
```console
java.lang.IllegalArgumentException: Failed requirement.
at androidx.wear.compose.material.ScalingLazyColumnKt$verticalNegativePadding$1.invoke-3p2s80s(ScalingLazyColumn.kt:725)
...
```



