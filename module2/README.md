* Запуск браузеров 
    - Исполняемые файлы-посредники
    - Выбор "правильной" версии браузера
    - Особенности запуска на разных операционных системах
    - Capabilities
    - Cookies, чистый и грязный запуск
    - Подробнее про каждый браузер (Chrome, Firefox, Internet Explorer, Edge, Safari, другие)
    - Работа с несколькими браузерами одновременно
    - WebDriverFactory

        
* Ожидания (WebDriverWait)
    - Ожидание появления
    - Ожидание видимости
    - Ожидание исчезновения
    - Ожидание свойств элемента
    - Ожидание нужного количества элементов
    - Произвольные условия ожидания
    - StaleElementReferenceException и борьба с ним
    - Неудачные попытки как альтернатива ожиданиям
    
    
    //        File file = new File("C:\\tools\\Firefox\\", "firefox.exe");
    //        if (file.exists()) {
    //            System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
    //        }
    
    
    
            DesiredCapabilities caps = new FirefoxOptions()
                    .setProfile(new FirefoxProfile())
                    .addTo(DesiredCapabilities.firefox());
                    
                    
                            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
