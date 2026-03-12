public class MP3 extends Gadget
{
    private int memory;
    
    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }
    public int getMemory()
    {
        return memory;
    }
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
    public void deleteMusic(int amount)
    {
        memory = memory + amount;
    }
    public void display()
    {
        super.display();
        System.out.println(" Memory: " + memory);
    }
}