import java.time.LocalDate;

public class SearchService {

    // Найти имена животных, родившихся в високосный год
    public String[] findLeapYearNames(AbstractAnimal[] animals) {
        String[] leapYearNames = new String[animals.length];
        int index = 0;
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                leapYearNames[index++] = animal.getName();
            }
        }
        return trimArray(leapYearNames, index); // Убираем лишние null
    }

    // Найти животных старше N лет
    public AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int years) {
        AbstractAnimal[] olderAnimals = new AbstractAnimal[animals.length];
        int index = 0;
        LocalDate currentDate = LocalDate.now();
        for (AbstractAnimal animal : animals) {
            if (currentDate.minusYears(years).isAfter(animal.getBirthDate())) {
                olderAnimals[index++] = animal;
            }
        }
        return trimArray(olderAnimals, index); // Убираем лишние null
    }

    // Найти дубликаты
    public void findDuplicate(AbstractAnimal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i] != null && animals[i].equals(animals[j])) {
                    System.out.println("Duplicate: " + animals[i].getName());
                }
            }
        }
    }

    private <T> T[] trimArray(T[] array, int size) {
        return java.util.Arrays.copyOf(array, size);
    }
}