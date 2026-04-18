// mobile class extends gadget
public class Mobile extends Gadget
{
    // mobile credit
    private int credit;

    // constructor
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model, price, weight, size); // call parent
        this.credit = credit;
    }

    public int getCredit()
    {
        return credit;
    }

    // add credit
     public void addCredit(int amount)
      {
          if(amount > 0)
       {
           credit = credit + amount;
       }
       else
       {
          System.out.println("Enter a positive credit amount.");
      }
    }

    // make a call
     public void makeCall(String phoneNumber, int duration)
    {
        if(credit >= duration)
        {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            credit = credit - duration;
        }
        else
        {
            System.out.println("Not enough credit.");
        }
    }

    // override display
    public void display()
    {
        super.display();
        System.out.println("Credit: " + credit);
    }
}