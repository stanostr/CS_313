package copying;

public class Dog implements Cloneable{
    private int weight;
    private String breed;
    private int age;

    public Dog(String breed)
    {
        this.breed = breed;
    }

    @Override
    public Dog clone() //we don't need to throw exception because we don't call super.clone()
    {
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
