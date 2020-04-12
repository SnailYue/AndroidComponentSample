# 整体架构

## 模块说明

App模块：一个壳模块

componenthome模块：主页模块

componentcontacts模块：联系人模块

componentsetting模模块：设置模块

componentbasic模块: 基础模块

componentlib模块：依赖包管理模块



## 模块单独打包说明

在gradle.properties文件中，配置有三个变量，IsModuleHome，IsModuleCOntacts，IsModuleSetting，分别对应主页模块，联系人模块，设置模块。

当需要单独打包某个模块时，将其改成true即可

## 注意事项

1.避免资源重名问题，需要在对应模块的build.gradle中配置resourcePrefix “模块名_”

```
resourcePrefix "componenthome_"
```



2.为了避免出现模块之间页面跳转报错的问题，需要在每个module中配置：

```
annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'
```



3.当某个module需要单独打包时，需要设置一个有默认启动界面配置的清单文件，单独的包名及单独的Plugin。

设置配置清单文件

```
sourceSets {
    main {
        if (!IsModuleHome.toBoolean()) {
            manifest.srcFile 'src/main/AndroidManifest.xml'
        } else {
            manifest.srcFile 'src/module/AndroidManifest.xml'
        }
    }
}
```

设置单独的包名

```
if (IsModuleHome.toBoolean()) {
    applicationId "com.snail.componenthome"
}
```

设置plugin

```
if (IsModuleHome.toBoolean()) {
    apply plugin: 'com.android.application'
} else {
    apply plugin: 'com.android.library'
}
```



4.为了避免导入的依赖包无法被继承，需要使用api导入，不能使用implementation

```
api 'com.alibaba:arouter-api:1.5.0'
annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'
```

