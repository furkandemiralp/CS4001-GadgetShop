// mp3 class extends gadget
public class MP3 extends Gadget
{
    // mp3 memory
    private int memory;

    // constructor
    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public int getMemory()
    {
        return memory;
    }

    // download music
    public void downloadMusic(int amount)
    {
        if(memory >= amount)
        {
            memory = memory - amount;
            System.out.println("Music downloaded.");
        }
        else
        {
            System.out.println("Not enough memory.");
        }
    }

    // delete music
    public void deleteMusic(int amount)
    {
        memory = memory + amount;
    }

    // override display
    public void display()
    {
        super.display();
        System.out.println("Memory: " + memory);
    }
}