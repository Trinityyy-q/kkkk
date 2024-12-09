import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    protected String breed;      // Порода
    protected String name;       // Имя
    protected Double cost;       // Цена
    protected String character;  // Характер
    protected LocalDate birthDate; // Дата рождения

    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    // Реализация
    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
