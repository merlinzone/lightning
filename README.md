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

## 三、使用方法
### 具体的使用方法可以参考Demo,以下的是在Application中的调用
```
     TaskDispatcher.init(this);
     TaskDispatcher dispatcher = TaskDispatcher.createInstance();
     dispatcher
             .addTask(new InitBuglyTask())
             .addTask(new InitLogTask())
             .addTask(new InitUmengTask())
             .start();
     dispatcher.await();
```