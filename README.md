Инструкция по запуску:
При установленном docker, находясь в корне проекта, прописать в bash docker-compose up
Функционал:
1. Добавление нового прибора - POST-запрос по адресу http://localhost:8080/registry/appliances/{type},
где в качестве type прописать тип добавляемого прибора: computer, fridge, tv, smartphone, vacuum.
В качестве тела запроса выступает JSON-файл с атрибутами прибора:
► String name - наименование линейки приборов
► String country - страна производства
► String manufacturer - компания-производитель
► Boolean availableOnline - возможность онлайн-заказа
► Boolean installmentOption - возможность покупки в рассрочку
2. Добавление новой модели прибора - POST-запрос по адресу http://localhost:8080/registry/models/post,
телом здесь так же выступает JSON файл с атрибутами модели:
Базовые атрибуты
● String type - тип прибора, обязательный атрибут, выбор опять же между computer, fridge, smartphone, vacuum и tv
● String applianceName - наименование линейки прибора, обязательный атрибут, может содержать часть названия
● String name - имя модели прибора
● String serialNumber - серийный номер
● String color - цвет
● String size - размер
● Integer price - цена в долларах
● Boolean inStock - наличие на складе
Уникальные атрибуты компьютера
● String processorType - тип процессора
● String category - категория компьютера
Уникальные атрибуты холодильника
● Integer doorsCount - количество дверей
● String compressorType - тип компрессора
Уникальные атрибуты смартфона
● Integer camerasCount - количество камер
● Integer memory - память в ГБ
Уникальные атрибуты пылесоса
● Double dustBagVolume - объём пылесборника
● Integer modesCount - количество режимов
Уникальные атрибуты телевизора
● String category - категория телевизора
● String technology - технология
3. Поиск моделей по различным фильтрам - POST-запрос по адресу http://localhost:8080/registry/models/get,
существуют 4 параметра, среди которых 2 для сортировки:
♦ String sortColumn - колонка сортировки, по умолчанию id
♦ String sortDirection - направление сортировки (ASC или DESC), по умолчанию ASC
и 2 параметра для пагинации:
♦ int page - номер страницы
♦ int size - количество отображаемых на странице моделей
Фильтры задаются в теле запроса в формате JSON, при этом атрибут type обязателен для запроса.
Список фильтров:
► String type - тип прибора, обязательный атрибут для выполнения запроса
► String applianceName - наименование линейки прибора
► String modelName - имя модели прибора
► String color - цвет
► Integer minPrice - минимальная цена
► Integer maxPrice - максимальная цена
Также фильтрацию можно проводить, используя уникальные атрибуты разных видов техники, описанные выше.
Работает веб-документация Swagger по адресу: http://localhost:8080/swagger-ui.html
