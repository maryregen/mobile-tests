<h1 >Проект автоматизации тестирования мобильного приложения 
<a href="https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk">Wikipedia</a></h1>

## Запуск тестов через командную строку

### Запуск тестов для browserstack
``` 
gradle clean android_test -DdeviceHost=browserstack
``` 

### Запуск тестов для emulation
``` 
gradle clean emulation_test -DdeviceHost=emulation
``` 