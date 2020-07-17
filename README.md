## 一、简介
Android App快如闪电的启动器

## 二、导入方式
### 将JitPack存储库添加到您的构建文件中(项目根目录下build.gradle文件)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 添加依赖项
仅支持`AndroidX`
```
dependencies {
    implementation 'com.github.ydstar:lightning:1.0.0'
}
```
