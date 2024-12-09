public class Main {
    public static void main(String[] args) {
        // Создаём сервисы
        CreateAnimalService createService = new CreateAnimalService();
        SearchService searchService = new SearchService();

        // Генерация животных
        AbstractAnimal[] animalsFromWhile = createService.generateAnimalsUsingWhile();
        AbstractAnimal[] animalsFromFor = createService.generateAnimalsUsingFor(5);
        AbstractAnimal[] animalsFromDoWhile = createService.generateAnimalsUsingDoWhile(7);

        // Поиск животных
        String[] leapYearNames = searchService.findLeapYearNames(animalsFromWhile);
        System.out.println("Animals born in leap years: " + String.join(", ", leapYearNames));

        AbstractAnimal[] olderAnimals = searchService.findOlderAnimal(animalsFromFor, 5);
        System.out.println("Animals older than 5 years:");
        for (AbstractAnimal animal : olderAnimals) {
            System.out.println("- " + animal.getName());
        }

        searchService.findDuplicate(animalsFromDoWhile);
    }
}