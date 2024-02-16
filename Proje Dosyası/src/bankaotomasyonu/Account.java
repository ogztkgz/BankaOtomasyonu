package bankaotomasyonu;

import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public abstract class Account 
{
	
    private int account_id;
    private int bakiye=0;
    protected AccountType type;
    public ArrayList<String> transactions;
    protected String openedDate;
    private LocalDate date;
    DateTimeFormatter dateTimeFormatter;
    protected LocalDate opening_account_date;
    private int puan = 0;
    
    public Account() 
    {
	
        
    	transactions = new ArrayList<String>();
    	dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	openedDate = LocalDate.now().format(dateTimeFormatter);
    	opening_account_date = LocalDate.now();
	}
	
	public void setBakiye(int bakiye) 
	{
		this.bakiye = bakiye;
	}
	
	public int getBakiye() 
	{
		return bakiye;
	}
	
	public void setAccountId(int id) 
	{	
		if(this.account_id == 0) 
		{
			this.account_id=id;
		}
		else 
		{
			System.out.println("Hesap id numarası değiştirilemez..");
		}
	}
	
	public int getAccountId() 
	{
		return this.account_id;
	}
	
	public  void deposit(int accountId, int cash) 
	{
	
		
		if(this.account_id==accountId) 
		{
			bakiye +=cash;
		}
	}
	
	public void withdraw(int accountId, int cash) 
	{
			
		if(account_id == accountId) 
		{
			bakiye -=cash;
		}
		
	}
	
	public int getBalance() 
	{
	
		
		return bakiye;
	}
	
	public int getId() 
	{
			
		return getAccountId();
	}
	
	public String  getDate() 
	{
		return openedDate;
	}
	
	public AccountType getType()
	{
		return type;
	}
	
        public void deposit(int amount) 
        {
        bakiye+= amount;
        puan += bakiye / 2000;
        }
        
        public abstract float benefit();
        
        public abstract void accountRules();
    

    
	
}

