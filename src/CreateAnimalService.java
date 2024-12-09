import java.time.LocalDate;

public class CreateAnimalService {

    // Метод: создание 10 животных с использованием while
    public AbstractAnimal[] generateAnimalsUsingWhile() {
        AbstractAnimal[] animals = new AbstractAnimal[10];
        int count = 0;
        while (count < 10) {
            AbstractAnimal animal = createRandomAnimal();
            animals[count] = animal;
            System.out.println("Created animal (while): " + animal.getName());
            count++;
        }
        return animals;
    }

    // Метод: создание N животных с использованием for
    public AbstractAnimal[] generateAnimalsUsingFor(int n) {
        AbstractAnimal[] animals = new AbstractAnimal[n];
        for (int i = 0; i < n; i++) {
            AbstractAnimal animal = createRandomAnimal();
            animals[i] = animal;
            System.out.println("Created animal (for): " + animal.getName());
        }
        return animals;
    }

    // Метод: создание N животных с использованием do-while
    public AbstractAnimal[] generateAnimalsUsingDoWhile(int n) {
        AbstractAnimal[] animals = new AbstractAnimal[n];
        int count = 0;
        do {
            AbstractAnimal animal = createRandomAnimal();
            animals[count] = animal;
            System.out.println("Created animal (do-while): " + animal.getName());
            count++;
        } while (count < n);
        return animals;
    }

    // Метод для создания случайного животного
    private AbstractAnimal createRandomAnimal() {
        String[] breeds = {"Wolf", "Tiger", "Cat", "Dog"};
        String[] characters = {"Friendly", "Aggressive", "Calm", "Playful"};

        String breed = breeds[(int) (Math.random() * breeds.length)];
        String name = breed + "_" + (int) (Math.random() * 100);
        double cost = Math.random() * 1000;
        String character = characters[(int) (Math.random() * characters.length)];
        LocalDate birthDate = randomDate();

        // 50% шанс создать либо Predator, либо Pet
        if (Math.random() < 0.5) {
            return new Predator(breed, name, cost, character, birthDate);
        } else {
            return new Pet(breed, name, cost, character, birthDate);
        }
    }

    // Метод для генерации случайной даты
    private LocalDate randomDate() {
        int year = (int) (Math.random() * (2024 - 2000 + 1) + 2000); // От 2000 до 2024
        int dayOfYear = (int) (Math.random() * 365 + 1);            // День в году
        return LocalDate.ofYearDay(year, dayOfYear);
    }
}