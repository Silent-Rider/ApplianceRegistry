Инструкция по запуску
1. Первоначально нужно импортировать созданную мной базу данных. Для этого первым делом нужно создать базу данных, подключившись к серверу PostgreSql.
Название БД можно придумать любое, но желательно appliance_registry(такое по умолчанию установлено в properties).
Далее необходимо восстановить бэкап БД под названием database.tar, лежащий в корневой папке проекта, в новосозданную БД с помощью команды в bash
pg_restore -d <имя созданной БД> <путь к database.tar>
2. Теперь необходимо изменить свойства в файле appliaction.properties, который лежит в папке src/main/resources.
Конкретно нужно поменять имя пользователя БД, имя самой БД и пароль, на те которые установлены у вас.
3. И непосредственно запуск программы осуществляется через bash с помощью команды java -jar target/appliance-registry-0.0.1-SNAPSHOT.jar (относительно коренвой директории)
Имеет 3 основых метода:
I. добавление нового прибора - POST-запрос по адресу http://localhost:8080/registry/appliances, в качестве тела запроса выступает JSON-файл с атрибутами прибора
II. добавление новой модели прибора - POST-запрос по адресу http://localhost:8080/registry/{тип прибора}/{наименование линейки}/models, также телом выступает JSON файл, куда нужно вписать атрибуты модели.
Если в наименовании линейки присутствуют пробелы, их нужно заменить дефисом (-), так сделано для удобства.
III. отображение моделей по различным фильтрам. GET-запрос по адресу localhost:8080/registry/models, где все фильтры задаются как параметры запроса. Пример:
http://localhost:8080/registry/models?minPrice=1000&color=Silver
Список фильтров: String applianceName, String modelName, String type, String color, Integer minPrice, Integer maxPrice;
Далее уникальные атрибуты моделей определенных типо техники:
Для компьютера: String category, String processorType,
Для холодильника: Integer doorsCount, String compressorType,
Для смартфона: Integer memory, Integer camerasCount,
Для ТВ: String category, String technology,
Для пылесоса: Double dustBagVolume, Integer modesCount.
Также реализована сортировка с помощью параметров String sortColumn и String sortDirection(с двумя видами значений "ASC" или "DESC")
Работает документация Swagger, при включенном приложении по адресу: http://localhost:8080/swagger-ui/index.html
